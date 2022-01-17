package com.company;

public class borrowerList {

    private String name;
    private String dateOfBirth;
    private String bookBorrowed;
    private String dateBookWasBorrowed;
    private String dateBookIsDue;

    public borrowerList(String name, String dateOfBirth, String bookBorrowed, String dateBookWasBorrowed, String dateBookIsDue) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.bookBorrowed = bookBorrowed;
        this.dateBookWasBorrowed = dateBookWasBorrowed;
        this.dateBookIsDue = dateBookIsDue;
    }

    @Override
    public String toString() {
        return name + "," + dateOfBirth + "," + bookBorrowed + "," + dateBookWasBorrowed + "," + dateBookIsDue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBookBorrowed() {
        return bookBorrowed;
    }

    public void setBookBorrowed(String bookBorrowed) {
        this.bookBorrowed = bookBorrowed;
    }

    public String getDateBookWasBorrowed() {
        return dateBookWasBorrowed;
    }

    public void setDateBookWasBorrowed(String dateBookWasBorrowed) {
        this.dateBookWasBorrowed = dateBookWasBorrowed;
    }

    public String getDateBookIsDue() {
        return dateBookIsDue;
    }

    public void setDateBookIsDue(String dateBookIsDue) {
        this.dateBookIsDue = dateBookIsDue;
    }
}
