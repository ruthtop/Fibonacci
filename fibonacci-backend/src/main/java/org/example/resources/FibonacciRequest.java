package org.example.resources;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

public class FibonacciRequest {
    @QueryParam("elements")
    @DefaultValue("0")
    private int queryStringElements;

    private int elements;

    // Default constructor
    public FibonacciRequest() {
    }

    // Constructor for query string elements
    public FibonacciRequest(int queryStringElements) {
        this.queryStringElements = queryStringElements;
    }

    // Constructor for JSON payload elements
    public FibonacciRequest(int queryStringElements, int elements) {
        this.queryStringElements = queryStringElements;
        this.elements = elements;
    }

    // Getter and setter for queryStringElements
    public int getQueryStringElements() {
        return queryStringElements;
    }

    public void setQueryStringElements(int queryStringElements) {
        this.queryStringElements = queryStringElements;
    }

    // Getter and setter for elements
    public int getElements() {
        return elements;
    }

    public void setElements(int elements) {
        this.elements = elements;
    }
}
