/*
 * Name: Alemeshet Ketema
 * Section: 3
 * Group: 6
 * Advanced Programming Individual assignment Calculator using RMI
 */

package com.calculator.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This is our Remote Interface. Think of it as a contract between the server and the client.
 * It tells the client exactly what operations the calculator can perform.
 * Since it's for RMI, every method must be able to throw a RemoteException in case 
 * something goes wrong with the network connection.
 */
public interface CalculatorInterface extends Remote {

    // Adds two numbers together. Simple and sweet!
    double add(double a, double b) throws RemoteException;

    // Subtracts the second number from the first.
    double subtract(double a, double b) throws RemoteException;

    // Multiplies two numbers.
    double multiply(double a, double b) throws RemoteException;

    // Divides the first number by the second. 
    // We'll need to handle division by zero in the implementation!
    double divide(double a, double b) throws RemoteException;
}
