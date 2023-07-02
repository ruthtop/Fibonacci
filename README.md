# Fibonacci

The code contains two folders - fibonacci-backend, containing the Dropwizard backend, and fibonacci-frontend, containing the React front-end. Each folder contains the respective dockerfile.

# To run the programs locally

1. Open the fibonacci-backend folder and fibonacci-frontend folder in separate IDE windows.
2. In the fibonacci-backend window, navigate src/main/java/org/example/resources/trueApplication.java. Right-click on the application and run it.
3. In the fibonacci-frontend folder, enter and run the command "npm install" in the terminal to install dependencies.
4. After installing the dependencies, enter and run the command "npm start" in the terminal to run the front-end.
5. This will build the back-end at http://localhost:8080/ and the front-end at http://localhost:3000/.
6. In your browser, access http://localhost:3000/.

# To build the program using containers

1. Open the main folder in the IDE.
2. Navigate to fibonacci-backend in the terminal using the command "cd fibonacci-backend"
3. Run the following command to build the dockerfile for backend: "docker build -t backend ." (You may replace "backend" with any other name.)
5. Navigate to fibonacci-frontend in the terminal using the commands "cd .." followed by "cd fibonacci-frontend"
6. Run the following command to build the dockerfile for backend: "docker build -t frontend ." (You may replace "frontend" with any other name.)
7. You will need to run the following commands in separate terminals. You may run one in the current IDE terminal, and the other in the regular command prompt. "docker run -p 8080:8080 fibonacci-backend", "docker run -p 3000:3000 fibonacci-frontend"
8. This will build the back-end at http://localhost:8080/ and the front-end at http://localhost:3000/.
9. In your browser, access http://localhost:3000/.
