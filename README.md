# 🧮 Java RMI Calculator Project

Hello! This is my individual assignment for the **Advanced Programming** course. I've built a distributed calculator using **Java Remote Method Invocation (RMI)**. 

The goal of this project was to create a system where a client can "talk" to a server over a network to perform math operations, making it feel like the math is happening locally even though it's being handled by the server!

---

## 👤 Student Information
- **Name:** Alemeshet Ketema
- **Section:** 3
- **Group:** 6
- **Assignment:** Advanced Programming Individual assignment - Calculator using RMI

---

## 📂 What's Inside?

I've organized the code into three main parts to keep things clean:

1.  **`CalculatorInterface.java`**: This is the "contract." It tells both the server and the client what operations (Add, Subtract, Multiply, Divide) are available.
2.  **`CalculatorServer.java`**: The "brain" of the operation. It stays awake, waits for requests, and does the actual math.
3.  **`CalculatorClient.java`**: The "face" of the project. This is what I use to type in numbers and see the results.

---

## 🚀 How to Get it Running

Running an RMI application is like a three-step dance:

### Step 1: Compile the Code
First, we need to turn the Java files into something the computer can run. Open your terminal in this folder and run:
```bash
javac src/com/calculator/rmi/*.java
```

### Step 2: Wake up the Server
The server needs to be running first so the client has someone to talk to.
```bash
java -cp src com.calculator.rmi.CalculatorServer
```
*You should see a message saying the server is ready!*

### Step 3: Start the Client
Open a **new terminal window** (keep the server one running!) and run:
```bash
java -cp src com.calculator.rmi.CalculatorClient
```
*Now you can start calculating!*

---

## ✨ Cool Features
- **Human-Friendly**: I've added lots of comments in the code so anyone reading it can understand *why* things are happening, not just *what* is happening.
- **Safety First**: If you try to divide by zero, the server won't crash—it'll politely tell you that it's a math error.
- **Distributed Logic**: The client only handles the UI, while the server handles all the heavy lifting.

---

