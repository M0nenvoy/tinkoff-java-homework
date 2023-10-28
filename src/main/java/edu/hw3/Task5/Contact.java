package edu.hw3.Task5;

public class Contact {
    private String name;
    private String surname;

    Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    Contact(String name) {
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
