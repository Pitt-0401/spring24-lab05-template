/*
 * Created on 2024-02-11
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    
    // Hint: adapt if you are reading data from a file
    private static boolean readingDataFromFile = false;

    public static void main(String[] args) {
        // TODO: read cats from the input file instead
        Cat userCat = readCatFromInput();
        printCatInfo(userCat);

        scanner.close();
    }

    // TODO: implement this method
    // You need to adapt the signature!
    public static void readCatsFromFile() {
    
    }

    // Read cat object from user input
    public static Cat readCatFromInput() {
        System.out.println("\n------Reading a new cat------");

        Owner owner = promptForOwner();
        Cat userCat = promptForCat();

        if (userCat != null) {
            userCat.adopt(owner);

            if (promptForStory()) {
                Story story = promptForStoryDetails();
                userCat.setFunnyStory(story);
            }
        }
        System.out.println("-----------------------------");

        return userCat;
    }

     /*
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * ! You only need to adapt (or remove) the prompts   !
     * ! (print statements) from the helper methods below !
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */
    public static void printCatInfo(Cat cat) {
        System.out.println();
        if (cat != null && cat.getOwner() != null) {
            System.out.print(cat.getOwner().getName() + " has adopted " + cat.getName());
            if (cat.getFur() != null && !cat.getFur().isEmpty() && cat.getAge() != 404) {
                System.out.print(" (" + cat.getFur() + " , " + cat.getAge() + ")");
            } else if (cat.getFur() != null && !cat.getFur().isEmpty() ) {
                System.out.print(" (" + cat.getFur() + ")");
            } else if (cat.getAge() != 404) {
                System.out.print(" (" + cat.getAge() + ")");
            }
            if ((cat.getFunnyStory() != null) && !(cat.getFunnyStory().getDescription().equals(""))) {
                System.out.println(" and shared this story: ");
                System.out.println(cat.getFunnyStory().toString());
            }
        }
    }

    // Helper methods to prompt the user for input
    private static Owner promptForOwner() {
        System.out.println("Please enter your name");
        String ownerName = scanner.nextLine();
        return new Owner(ownerName);
    }

    private static Cat promptForCat() {
        System.out.println("Please enter your cat's name");
        String name = scanner.nextLine();

        System.out.println("Please enter your cat's fur color");
        String fur = scanner.nextLine();

        int age = 404; // Default if not set
        System.out.println("Please enter your cat's age");
        boolean validInput = false;
        while (!validInput) {
            try {
                age = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                if (!readingDataFromFile) {
                    System.out.println(e.toString() + " -- Invalid input, please input your cat's age as a number.");
                    scanner.nextLine();
                } else {
                    System.out.println(e.toString() + " -- Invalid input, not a number.");
                    validInput = true;
                }
            }
        }
        scanner.nextLine();
        return new Cat(name, fur, age);
    }

    private static Story promptForStoryDetails() {
        System.out.println("Give your funny story a title");
        String storyTitle = scanner.nextLine();
        System.out.println("Share your funny story");
        String storyDescription = scanner.nextLine();
        return new Story(storyTitle, storyDescription);
    }

    private static boolean promptForStory() {
        if (readingDataFromFile) {
            return true;
        }
        System.out.println("Do you want to share a funny story about your cat? (yes/no)");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("yes");
    }
}
