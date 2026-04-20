/*Name: Manuel Ortiz
 *Date: 04/19/2026
 *Assignment: 2.2 Project: Software Design and Control Statements
 *Description: Commands.java
 *This is where all the actual math happens.
 *Addition, subtraction, multiplication, and division all live here.
 *This class also handles error checking so nothing blows up.
 */

import java.text.DecimalFormat;

public class Commands {
 
    // Create a DecimalFormat object to format results to 4 decimal places and trim trailing zeros
    static DecimalFormat df = new DecimalFormat("0.####");

    // This method takes a string expression and performs the corresponding math operation
    public static void handleExpression(String input) {
 
        // Check which operator the user typed and run the matching operation
        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            if (parts.length == 2) {
                double num1 = Double.parseDouble(parts[0].trim());
                double num2 = Double.parseDouble(parts[1].trim());
                addition(num1, num2);
            } else {
                System.out.println();
                System.out.println("=============================================================================");
                System.out.println("           [ERROR] Incomplete formula. Try something like  1 + 2             ");
                System.out.println("=============================================================================");
            }
 
        } else if (input.contains("*")) {
            String[] parts = input.split("\\*");
            if (parts.length == 2) {
                double num1 = Double.parseDouble(parts[0].trim());
                double num2 = Double.parseDouble(parts[1].trim());
                multiplication(num1, num2);
            } else {
                System.out.println();
                System.out.println("=============================================================================");
                System.out.println("           [ERROR] Incomplete formula. Try something like  1 * 2             ");
                System.out.println("=============================================================================");
            }
 
        } else if (input.contains("/")) {
            String[] parts = input.split("/");
            if (parts.length == 2) {
                double num1 = Double.parseDouble(parts[0].trim());
                double num2 = Double.parseDouble(parts[1].trim());
                division(num1, num2);
            } else {
                System.out.println();
                System.out.println("=============================================================================");
                System.out.println("           [ERROR] Incomplete formula. Try something like  1 / 2             ");
                System.out.println("=============================================================================");
            }
 
        } else if (input.contains("-")) {
            // Subtraction is checked last because negative numbers also have a dash
            String[] parts = input.split("-");
            if (parts.length == 2) {
                double num1 = Double.parseDouble(parts[0].trim());
                double num2 = Double.parseDouble(parts[1].trim());
                subtraction(num1, num2);
            } else {
                System.out.println();
                System.out.println("=============================================================================");
                System.out.println("           [ERROR] Incomplete formula. Try something like  1 - 2             ");
                System.out.println("=============================================================================");
            }
 
        } else {
            // If no valid operator was found print an error
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println("                   [ERROR] I could not understand that formula.              ");
            System.out.println("                   Try something like  1 + 2  or  1.5 / 2.5                  ");
            System.out.println("=============================================================================");
        }
    }
 
    // Adds two numbers together and displays the result
    public static void addition(double num1, double num2) {
        double result = num1 + num2;
        displayResult(num1, "+", num2, result);
    }
 
    // Subtracts num2 from num1 and displays the result
    public static void subtraction(double num1, double num2) {
        double result = num1 - num2;
        displayResult(num1, "-", num2, result);
    }
 
    // Multiplies two numbers and displays the result
    public static void multiplication(double num1, double num2) {
        double result = num1 * num2;
        displayResult(num1, "*", num2, result);
    }
 
    // Divides num1 by num2 and displays the result
    // Checks for division by zero first and prints an error if the user tries it
    public static void division(double num1, double num2) {
        if (num2 == 0) {
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println("                   [ERROR] Division by zero is undefined.                    ");
            System.out.println("            Even this calculator has limits. Try a different number.         ");
            System.out.println("=============================================================================");
        } else {
            double result = num1 / num2;
            displayResult(num1, "/", num2, result);
        }
    }
 
    // Handles all result formatting for the entire program
    // Always displays in the format:  num1 operator num2 = result
    // Trims trailing zeros so 7.2500 shows as 7.25
    public static void displayResult(double num1, String operator, double num2, double result) {
 
        // Format the result to 4 decimal places and trim trailing zeros
        String formattedResult = df.format(result);
 
        // Format the input numbers as well so they look nice in the output, especially if they have trailing zeros or are whole numbers
        String formattedNum1 = df.format(num1);
 
        // Format num2 as well so it looks nice in the output, especially if it has trailing zeros or is a whole number
        String formattedNum2 = df.format(num2);
 
        // Print the result in the format:  num1 operator num2 = result
        System.out.println();
        System.out.println(" " + formattedNum1 + " " + operator + " " + formattedNum2 + " = " + formattedResult);
        System.out.println();
    }
}
