//clean code easy to read, rename the file to something more appropriate, maybe use an arraylist........
package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
//you could use an ArrayList
public class Main {

    private static File bookInfoFile = new File("NewFilename.txt");

    public static void main(String[] args) {

        CreateFile();

        writeToFile();
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

    public static void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter(bookInfoFile.getName(), false);
            String[] data = new String[4];
            boolean loop = false;
            while (loop == false){
                data = getBookInfo(data);
                myWriter.write(data[0] + " ," + data[1] + " ," + data[2] + " ," + data[3] + "\n");
                myWriter.close();
                String answer = getInput("Do you want to add another book y/n");
                if (answer.equals("n")) {
                    loop = true;
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String[] getBookInfo(String[] data) {

        data[0] = getInput("What is the title of the book");

        data[1] = getInput("What is the ISBN of the book");

        data[2] = getInput("Who is the author of the book");

        data[3] = getInput("What is the genre of the book");

        return (data);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
