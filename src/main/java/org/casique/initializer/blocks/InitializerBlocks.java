package org.casique.initializer.blocks;

public class InitializerBlocks {

    // Initializer block starts..
    {
        // This code is executed before every constructor.
        System.out.println(
                "Common part of constructors invoked 1!!");
    }
    // Initializer block ends

    // Constructor 1
    // Default constructor
    public InitializerBlocks()
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
    public InitializerBlocks(int x)
    {

        // Print statement
        System.out.println(
                "Parameterized constructor invoked");
    }

    static{
        // This code is executed before every constructor.
        System.out.println(
                "Common part of constructors invoked 3!!");
    }

    // Main driver method
    public static void main(String arr[])
    {

        String textBlock = """
            "Java Study Guide"
            by Scott & Jeanne
        """;
        // Creating variables of class type
        InitializerBlocks obj1, obj2;

        // Now these variables are
        // made to object and interpreted by compiler
        obj1 = new InitializerBlocks();

        obj2 = new InitializerBlocks(0);
    }
}
