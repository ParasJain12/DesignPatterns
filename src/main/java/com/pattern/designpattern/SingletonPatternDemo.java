package com.pattern.designpattern;

// Singleton class
class Singleton {
    // Step 1: create a private static instance
    private static Singleton instance;

    // Step 2: make the constructor private (so no one can create object directly)
    private Singleton() {
        System.out.println("Singleton Instance Created!");
    }

    // Step 3: provide a public static method to get the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // create object only once
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Main class to test
public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Get the only object from Singleton class
        Singleton obj1 = Singleton.getInstance();
        obj1.showMessage();

        // Get another reference to same object
        Singleton obj2 = Singleton.getInstance();

        // Check if both references are same
        System.out.println(obj1 == obj2);  // true (same object)
    }
}
