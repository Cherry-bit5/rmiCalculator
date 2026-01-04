/*
 * Name: Alemeshet Ketema
 * Section: 3
 * Group: 6
 * Advanced Programming Individual assignment Calculator using RMI
 */

package com.calculator.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * This is the Server implementation. 
 * It does two things: 
 * 1. Implements the math logic defined in our interface.
 * 2. Sets up the RMI registry so clients can find this service.
 */
public class CalculatorServer extends UnicastRemoteObject implements CalculatorInterface {

    // The constructor needs to throw RemoteException because UnicastRemoteObject does.
    protected CalculatorServer() throws RemoteException {
        super();
    }

    @Override
    public double add(double a, double b) throws RemoteException {
        System.out.println("Server: Adding " + a + " and " + b);
        return a + b;
    }

    @Override
    public double subtract(double a, double b) throws RemoteException {
        System.out.println("Server: Subtracting " + b + " from " + a);
        return a - b;
    }

    @Override
    public double multiply(double a, double b) throws RemoteException {
        System.out.println("Server: Multiplying " + a + " by " + b);
        return a * b;
    }

    @Override
    public double divide(double a, double b) throws RemoteException {
        System.out.println("Server: Dividing " + a + " by " + b);
        if (b == 0) {
            throw new RemoteException("Math Error: Cannot divide by zero!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            // Create an instance of our calculator
            CalculatorServer server = new CalculatorServer();

            // Start the RMI registry on port 1099 (the default RMI port)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object's stub in the registry
            // We give it a name "CalculatorService" so the client can look it up
            registry.rebind("CalculatorService", server);

            System.out.println(">>> Calculator Server is running and ready for requests! <<<");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
