import './App.css';

import { BrowserRouter, Route, Routes } from 'react-router-dom'
import React, { useState, useEffect, useRef, Suspense } from 'react'


const InputForm = () => {
    const [elements, setElements] = useState("");
    const [fibonacci, setFibonacci] = useState([]);
    const [sorted, setSorted] = useState([]);
    // form
    const formRef = useRef(null);
    const [errorMessage, setErrorMessage] = useState("");

    useEffect(() => {
        if (elements){
            fetchData();
        }
    }, [elements]);

    const fetchData = async () => {
        try {
            const response = await fetch(
                `http://localhost:8080/fibonacci?elements=${elements}`,
                {
                    method: 'GET'
                }
            );

            if (response.ok) {
                const data = await response.json();
                setFibonacci(data.fibonacci.map(String));
                setSorted(data.sorted.map(String));
            } else {
                console.error('Failed to fetch data. Status:', response.status);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    return (
        <div style={{ marginLeft: '20px' }}>
            <>
                <h1>Fibonacci</h1>
                <form ref={formRef}>
                    <label>Enter an integer from 1-100: <br />
                        <input
                            style={{ marginTop: '5px' }}
                            type="text"
                            name="elements"
                            value={elements}
                            onChange={(e) => {
                                const inputValue = e.target.value;
                                const numberValue = parseInt(inputValue, 10);
                                if (inputValue.trim() === "") {
                                    setErrorMessage("");
                                    setElements("");
                                    setFibonacci([]); // Clear the fibonacci array
                                    setSorted([]); // Clear the sorted array
                                } else if (isNaN(numberValue) || numberValue < 1 || numberValue > 100) {
                                    setErrorMessage("Please enter an integer from 1-100.");
                                } else {
                                    setErrorMessage("");
                                    setElements(numberValue);
                                }
                            }}
                        />
                    </label>
                </form>
            </>
            <>{errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}</>
            <>
                <h2>Fibonacci Sequence:</h2>
                {fibonacci.length > 0 ? (
                    <span style={{ display: 'inline-block', maxWidth: '400px' }}>
                        {fibonacci.map((num, index) => (
                            <span key={index}>{num}{index !== sorted.length - 1 && ', '}</span>
                        ))}
                    </span>
                ) : (
                    <p>Nothing here yet</p>
                )}
            </>
            <>
                <h2>Sorted Sequence:</h2>
                {sorted.length > 0 ? (
                    <span style={{ display: 'inline-block', maxWidth: '400px' }}>
                        {sorted.map((num, index) => (
                            <span key={index}>{num}{index !== sorted.length - 1 && ', '}</span>
                        ))}
                    </span>
                ) : (
                    <p>Nothing here yet</p>
                )}
            </>
        </div>
    )
}

const loading = (
    <div>
        <h1>Still Loading</h1>
    </div>
)

function App() {
        return (
            <BrowserRouter>
                <Suspense fallback={loading}>
                    <Routes>
                        <Route path="*" name="Home" element={<InputForm />} />
                    </Routes>
                </Suspense>
            </BrowserRouter>
        )
}

export default App;