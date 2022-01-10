package com.company;

import java.util.ArrayList;

public class bookBorrowing {

    public static void displayBorrowingMenu(String email, String password, ArrayList<String> data) {
        String response = "";
        String answer = "";
        boolean admin = false;
        while (!response.equals("Q")) {
            System.out.println("A: Borrow a book");
            System.out.println("B: Delete books (Admin needed)");
            System.out.println("C: Delete borrowers (Admin needed)");
            System.out.println("D: View all books and borrowers");
            System.out.println("Q: Quit");
            System.out.println("");
            response = Main.getInput("Please enter the letter of the option you want to choose");
        }
        if (response.equals("A")) {
            if (admin == true) {
                borrowBook();
            }
            else {
                System.out.println("You are not logged into an admin account");
                answer = Main.getInput("Do you want to sign into one? y/n");
                if (answer.equals("y")){
                    admin = adminClass.logIn(admin);
                    if (admin == true) {
                        borrowBook();
                    }
                }
                else {
                    System.out.println("Returning to menu" + "\n");
                }
            }
        }
    }

    public static void borrowBook() {

    }
}

