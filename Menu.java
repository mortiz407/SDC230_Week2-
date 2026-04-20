/*Name: Manuel Ortiz
 *Date: 04/19/2026
 *Assignment: 2.2 Project: Software Design and Control Statements
 *Description:Menu.java
 *This class handles everything the user sees.
 *The header, welcome message, random quotes, help table,
 *main input loop, and closing message all live here.
 */

import java.util.Scanner;

// Random quote generator class
import java.util.Random;

public class Menu {

    // This variable is used to track how many times the user has entered nonsense
    // input
    static int nonsenseCounter = 0;

    public static void start(Scanner input) {

        // Print the header
        printHeader();

        // Print the welcome message with a random quote
        printWelcomeMessage();

        // Start the main input loop
        handleUserInput(input);
    }

    // Print the header of the program
    public static void printHeader() {
        System.out.println("==========================================================");
        System.out.println("                    MANUEL'S CALCULATOR                   ");
        System.out.println("   Week 2 Project: Software Design and Control Statements ");
        System.out.println("==========================================================");
    }

    // Print the welcome message with a random quote
    public static void printWelcomeMessage() {
        System.out.println();
        System.out.println(" " + getRandomQuote());
        System.out.println();
        System.out.println("            Welcome back to the Java Calculator!          ");
        System.out.println();
        System.out.println("             Type 'HELP' to see all commands              ");
        System.out.println("             Type 'EXIT' to quit the program              ");
        System.out.println("==========================================================");
    }

    // Pick a random quote from the array and return it
    public static String getRandomQuote() {

        // Array of random quotes to choose from
        String[] quotes = {
                "A programmer's diet: coffee, bugs, and recursion.",
                "Why do programmers prefer dark mode? Because light attracts bugs.",
                "Math is just spicy counting.",
                "Warning: this calculator is smarter than your ex.",
                "Some doors only open for those brave enough to knock. Others require correcrt arithmetic.",
                "There are 10 types of people in the world. Those who understand binary and those who don't.",
                "Debugging is like being the detective in a crime movie where you are also the murderer.",
                "A good programmer is someone who looks both ways before crossing a one way street.",
                "Code never lies. Comments sometimes do.",
                "The only thing more dangerous than a zombie apocalypse... is a math problem you can't solve."
        };

        // Generate a random index to select a quote
        Random rand = new Random();

        // Return the randomly selected quote
        return quotes[rand.nextInt(quotes.length)];
    }

    // Print the help menu
    public static void printHelpMenu() {
        System.out.println();
        System.out.println("===========================================================");
        System.out.println("                        Help Menu                          ");
        System.out.println("===========================================================");
        System.out.println("        Commands            |            Description       ");
        System.out.println("===========================================================");
        System.out.println("        1 + 2               |            Addition          ");
        System.out.println("        1 - 2               |            Subtraction       ");
        System.out.println("        1 * 2               |            Multiplication    ");
        System.out.println("        1 / 2               |            Division          ");
        System.out.println("        [calculation]       |            AVG               ");
        System.out.println("        [calculation]       |            MAX               ");
        System.out.println("        [calculation]       |            MIN               ");
        System.out.println("        HELP                |            Show this menu    ");
        System.out.println("        EXIT                |            Exit the program  ");
        System.out.println("===========================================================");
        System.out.println("                       ...Zombie                           ");
        System.out.println("===========================================================");
    }

    // Print the closing message when the user exits the program
    public static void printClosingMessage() {
        System.out.println();
        System.out.println("===========================================================");
        System.out.println("                 Thanks for using the calculator!          ");
        System.out.println("                 Stay safe out there...                    ");
        System.out.println("===========================================================");
    }

    // This method handles the main input loop of the program
    public static void handleUserInput(Scanner input) {

        // This variable is used to control the main input loop
        boolean running = true;

        // Main input loop
        while (running) {
            System.out.print(" > ");
            String userInput = input.nextLine().trim();

            // Check if the user wants to exit
            if (userInput.equalsIgnoreCase("EXIT")) {

                // Print the closing message before exiting
                printClosingMessage();

                // Set running to false to exit the loop and end the program
                running = false;

                // If the user wants help, print the help menu
            } else if (userInput.equalsIgnoreCase("HELP")) {

                // Reset the nonsense counter when the user asks for help
                nonsenseCounter = 0;

                // Print the help menu
                printHelpMenu();

            } else if (userInput.equalsIgnoreCase("ZOMBIE")) {

                // If the user enters the secret command "ZOMBIE", trigger the Easter egg and
                // print a message
                System.out.println();
                System.out.println("===========================================================");
                System.out.println("             Oh. You found the secret command...           ");
                System.out.println("                         ...Zombie                         ");
                System.out.println("                            Smart.                         ");
                System.out.println();
                System.out.println("                 Zombie Gaunlet coming soon...             ");
                System.out.println("===========================================================");

            } else if (userInput.contains("+") || userInput.contains("-") || userInput.contains("*") ||
                    userInput.contains("/") || userInput.contains("AVG") || userInput.contains("MAX")
                    || userInput.contains("MIN")) {
                // If the user input contains a valid calculation command, reset the nonsense
                // counter
                nonsenseCounter = 0;

                // Call the Calculation class to handle the calculation
                Commands.handleExpression(userInput);
            } else {
                // If the user input is not recognized, increment the nonsense counter and print
                // a message
                nonsenseCounter++;
                checkEsterEggs(userInput, nonsenseCounter);
            }
        }
    }

    // This method checks if the user has entered nonsense input multiple times and
    // triggers an Easter egg if they have
    public static void checkEsterEggs(String userInput, int nonsenseCounter) {
        if (nonsenseCounter == 1) {

            // If the user has entered nonsense input once, print a message encouraging them
            // to try again
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println(" [ERROR] \\\"" + userInput + "\\\" is not a valid command. Please try again. ");
            System.out.println("       Try typing a formula like '1 + 2' or HELP to see all commands.        ");
            System.out.println("=============================================================================");
            System.out.println();
        } else if (nonsenseCounter == 2) {

            // If the user has entered nonsense input 2 times, print a more stern message
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println("     [ERROR] Still not MATH. I don't know what you are doing but STOP.       ");
            System.out.println("=============================================================================");
            System.out.println();

        } else if (nonsenseCounter == 3) {

            // If the user has entered nonsense input 3 times, trigger the Easter egg and
            // print a message
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println("        [ERROR] That's not math. That's not even close to math.              ");
            System.out.println("                                   ...                                       ");
            System.out.println("                                   ...                                       ");
            System.out.println("                            You know what, fine.                             ");
            System.out.println("                        Since you want to play games...                      ");
            System.out.println("                 Welcome to the Zombie Gauntlet. Good luck.                  ");
            System.out.println("                        You are going to need it.                            ");
            System.out.println();
            System.out.println("=============================================================================");

            // Reset the nonsense counter after the user has triggered the Easter egg
            nonsenseCounter = 0;

            // Call the Zombie class to start the Zombie Gauntlet game
            Zombies.start();

        }
    }
}
