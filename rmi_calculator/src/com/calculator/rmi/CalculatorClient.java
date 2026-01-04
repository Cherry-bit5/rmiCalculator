/*
 * Name: Alemeshet Ketema
 * Section: 3
 * Group: 6
 * Advanced Programming Individual assignment Calculator using RMI
 */

package com.calculator.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * This is the Client application.
 * It connects to the server, asks the user for input, 
 * and calls the remote methods to get the results.
 */
public class CalculatorClient {

    public static void main(String[] args) {
        try {
            // 1. Connect to the RMI registry on the server (localhost in this case)
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // 2. Look up the "CalculatorService" we registered on the server
            CalculatorInterface stub = (CalculatorInterface) registry.lookup("CalculatorService");

            // 3. Set up a scanner for user input
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("--- Welcome to the RMI Calculator ---");
            System.out.println("Connected to server successfully!");

            while (true) {
                System.out.println("\nChoose an operation:");
                System.out.println("1. Add (+)");
                System.out.println("2. Subtract (-)");
                System.out.println("3. Multiply (*)");
                System.out.println("4. Divide (/)");
                System.out.println("5. Exit");
                System.out.print("Enter choice (1-5): ");
                
                int choice = scanner.nextInt();
                if (choice == 5) {
                    System.out.println("Goodbye! Thanks for using the calculator.");
                    break;
                }

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                boolean valid = true;

                // 4. Call the remote methods based on user choice
                switch (choice) {
                    case 1:
                        result = stub.add(num1, num2);
                        break;
                    case 2:
                        result = stub.subtract(num1, num2);
                        break;
                    case 3:
                        result = stub.multiply(num1, num2);
                        break;
                    case 4:
                        try {
                            result = stub.divide(num1, num2);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            valid = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        valid = false;
                }

                if (valid) {
                    System.out.println(">>> Result: " + result);
                }
            }
            scanner.close();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
