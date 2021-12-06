
package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static File bookInfoFile = new File("NewFilename.txt");

    public static void main(String[] args) {

        CreateFile();

        String email = "";
        email = getEmail(email);
        String password = "";
        password = getPassword(password);

        register(email,password);

        displayMenu(email,password);

        deleteFile();

    }

    public static void CreateFile() {
        try {
            if (bookInfoFile.createNewFile()) {
                System.out.println("File created: " + bookInfoFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void displayMenu(String email, String password) {
        String response = "";
        String answer = "";
        boolean admin = false;
        ArrayList<String> data = new ArrayList<>();
        while (!response.equals("Q")) {
            System.out.println("A: Add to the file (Admin needed)");
            System.out.println("B: Display everything in the file");
            System.out.println("C: Delete a book from the file (Admin needed)");
            System.out.println("D: Search for a book in the system");
            System.out.println("Q: Quit");
            System.out.println("");
            response = getInput("Please enter the letter of the option you want to choose");
            if (response.equals("A")) {
                if (admin == true) {
                    writeToFile(data, email, password);
                }
                else {
                    System.out.println("You are not logged into an admin account");
                    answer = getInput("Do you want to sign into one? y/n");
                    if (answer.equals("y")){
                        admin = logIn(admin);
                        if (admin == true) {
                            writeToFile(data, email, password);
                        }
                    }
                    else {
                        System.out.println("Returning to menu" + "\n");
                    }
                }
            }
            if (response.equals("B")) {
                displayFile();
            }
            if (response.equals("C")) {
                if (admin == true) {
                    deleteBook(data, password, email);
                }
                else {
                    System.out.println("You are not logged into an admin account");
                    answer = getInput("Do you want to sign into one? y/n");
                    if (answer.equals("y")){
                        admin = logIn(admin);
                        if (admin == true) {
                            writeToFile(data, email, password);
                        }
                    }
                    else {
                        System.out.println("Returning to menu" + "\n");
                    }
                }
            }
            if (response.equals("D")) {
                searchForBook():
            }

        }

    }

    public static ArrayList<String> writeToFile(ArrayList<String> data, String email, String password) {
        try {
            FileWriter myWriter = new FileWriter(bookInfoFile.getName(), false);
            boolean loop = false;
            String info = "";
            while (loop == false){
                data.add(getBookInfo(info));
                String answer = getInput("Do you want to add another book y/n");
                if (answer.equals("n")) {
                    loop = true;
                }
            }
            myWriter.write(email + "\n" + password + "\n" + "\n");
            for (int i = 0; i < data.size(); i++){
                myWriter.write(data.get(i) + "\n");
            }
            myWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return(data);
    }

    public static String getBookInfo(String info) {
        info = "";
        info = info + (getInput("What is the title of the book")) + ", ";
        info = info + (getInput("What is the ISBN of the book")) + ", ";
        info = info + (getInput("Who is the author of the book")) + ", ";
        info = info + (getInput("What is the genre of the book"));
        return (info);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void displayFile() {
        try{
            Scanner myReader = new Scanner(bookInfoFile);
            System.out.println("Here is the information on all the books you added");
            System.out.println("");
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
            }
            System.out.println("");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void deleteFile() {
        if (bookInfoFile.delete()) {
            System.out.println("Deleted the file: " + bookInfoFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static String getEmail(String email) {
        boolean valid = false;
        while(!valid){
            email = getInput("Please enter the email you would like to use for your admin account");
            if (email.contains("@") && email.contains(".")) {
                valid = true;
            }
            else{
                System.out.println("Please enter a valid email");
            }
        }
        return(email);
    }

    public static String getPassword(String password) {
        boolean valid = false;
        while(!valid) {
            password = getInput("Please enter the password you would like to use");
            if (password.length() > 6) {
                valid = true;
            }
            else{
                System.out.println("Password is too short");
            }
        }
        return(password);
    }

    public static void register(String email, String password) {
        try{
            FileWriter myWriter = new FileWriter(bookInfoFile.getName(), false);
            myWriter.write(email + "\n" + password + "\n" + "\n");
            myWriter.close();
            System.out.println("Admin account created");
            System.out.println("");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean logIn(boolean admin) {
        try{
            boolean valid = false;
            String response = "";
            while(!valid) {
                Scanner myReader = new Scanner(bookInfoFile);
                String email = getInput("What is the email of your account? ");
                String password = getInput("What is your password? ");
                if (email.equals(myReader.nextLine())) {
                    if (password.equals(myReader.nextLine())) {
                        System.out.println("Successfully logged into admin account");
                        System.out.println("");
                        valid = true;
                        admin = true;
                    }
                    else {
                        System.out.println("Password is incorrect");
                        response = getInput("Do you want to continue trying to log in? y/n");
                        if (response.equals("n")) {
                            valid = true;
                        }
                    }
                }
                else {
                    System.out.println("email is incorrect");
                    response = getInput("Do you want to continue trying to log in? y/n");
                    if (response.equals("n")) {
                        valid = true;
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return(admin);
    }

    public static ArrayList<String> deleteBook(ArrayList<String> data, String password, String email) {
        try {
            Scanner myReader = new Scanner(bookInfoFile);
            int count = -4;
            String line = "";
            String book = getInput("What is the title of the book you would like to remove from the file");
            while (myReader.hasNextLine()) {
                count = count + 1;
                line = myReader.nextLine();
                if (line.contains(book)) {
                    FileWriter myWriter = new FileWriter(bookInfoFile.getName(), false);
                    data.set(count,"*deleted*");
                    myWriter.write(email + "\n" + password + "\n" + "\n");
                    for (int i = 0; i < data.size(); i++){
                        myWriter.write(data.get(i) + "\n");
                    }
                    myWriter.close();
                    System.out.println("Book deleted");
                    System.out.println("");

                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return(data);
    }
}
