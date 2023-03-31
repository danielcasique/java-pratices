package org.casique.oop.casting;

class Member {

    // Member variable of this class
    String name;
    long phone;

    // Member function of this class
    void chat()
    {

        // Print message of Member/ Child class
        System.out.println(
                name + " : chatting in whatsapp group");
    }
}

// Class 2
// Child class/ Admin class
class Admin extends Member {

    // Member function of this class
    void addUser()
    {

        // Print message of Admin/ Parent class
        System.out.println(
                name
                        + " : adding a new user in whatsapp group");
    }
}

// Class3 - Main class
public class Casting {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating an object Ad
        Member mem = new Admin();
        Member mem2 = new Member();

        // Upcasting access only general property of
        // superclass

        // Custom entry for Member class
        mem.name = "Sneha";
        mem.phone = 9876543210l;
        // Calling function
        mem.chat();

        Admin ad = (Admin)mem;
        Admin ad2 = (Admin)mem2;
        // Downcast to access specific property of subclass
        ad.addUser();
    }
}

