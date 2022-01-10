package com.company;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class adminClass {

    public static String getEmail(String email) {
        boolean valid = false;
        while(!valid){
            email = Main.getInput("Please enter the email you would like to use for your admin account");
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
            password = Main.getInput("Please enter the password you would like to use");
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
            FileWriter myWriter = new FileWriter(Main.bookInfoFile.getName(), false);
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
                Scanner myReader = new Scanner(Main.bookInfoFile);
                String email = Main.getInput("What is the email of your account? ");
                String password = Main.getInput("What is your password? ");
                if (email.equals(myReader.nextLine())) {
                    if (password.equals(myReader.nextLine())) {
                        System.out.println("Successfully logged into admin account");
                        System.out.println("");
                        valid = true;
                        admin = true;
                    }
                    else {
                        System.out.println("Password is incorrect");
                        response = Main.getInput("Do you want to continue trying to log in? y/n");
                        if (response.equals("n")) {
                            valid = true;
                        }
                    }
                }
                else {
                    System.out.println("email is incorrect");
                    response = Main.getInput("Do you want to continue trying to log in? y/n");
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
}
