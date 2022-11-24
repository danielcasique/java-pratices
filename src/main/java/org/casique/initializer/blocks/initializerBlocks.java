package org.casique.initializer.blocks;

public class initializerBlocks {

    // Initializer block starts..
    {
        // This code is executed before every constructor.
        System.out.println(
                "Common part of constructors invoked 1!!");
    }
    // Initializer block ends

    // Constructor 1
    // Default constructor
    public initializerBlocks()
    {

        // Print statement
        System.out.println("Default Constructor invoked");
    }

    {
        // This code is executed before every constructor.
        System.out.println(
                "Common part of constructors invoked 2!!");
    }

    // Constructor 2
    // Parameterized constructor
    public initializerBlocks(int x)
    {

        // Print statement
        System.out.println(
                "Parameterized constructor invoked");
    }

    {
        // This code is executed before every constructor.
        System.out.println(
                "Common part of constructors invoked 3!!");
    }

    // Main driver method
    public static void main(String arr[])
    {

        // Creating variables of class type
        initializerBlocks obj1, obj2;

        // Now these variables are
        // made to object and interpreted by compiler
        obj1 = new initializerBlocks();

        obj2 = new initializerBlocks(0);
    }
}
