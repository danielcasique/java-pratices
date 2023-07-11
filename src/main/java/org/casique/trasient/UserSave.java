package org.casique.trasient;

import lombok.Data;
import lombok.ToString;

import java.io.*;

/*
class User
{
    String password;
    int age;
    String username;
    String email;

}

public class UserSave {

    public static void main(String[] args)
    {
        User input = new User();
        input.password = "Test1234";
        input.age = 15;
        input.username = "test";
        input.email = "test@test.com";

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(input);

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        User output = (User )ois.readObject();
        System.out.println(output.toString());
    }
}
*/

/**
 * structure of a java class
 * packages and imports
 * methods and arguments
 * autoboxing / unboxing
 * primitive types
 * serialization / deserialization
 * try (Closeable, Flushable)
 * Design Pattern: Builder
 * SOLID: el main no es single responsability / no esta cerrado a la modificación
 */

@ToString
@Data
class User implements Serializable {
    private transient String password;
    private Integer age;
    private String username;
    private String email;

}

public class UserSave {

    public static void main(String[] args) throws Exception {
        User input = new User();
        input.setPassword("Test1234");
        input.setAge(15);
        input.setUsername("test");
        input.setEmail("test@test.com");

        try (FileOutputStream fos = new FileOutputStream("abc.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(input);

        }

        try(FileInputStream fis = new FileInputStream("abc.txt")){
            ObjectInputStream ois = new ObjectInputStream(fis);
            User output = (User) ois.readObject();
            System.out.println(output.toString());
            int total = output.getAge();
            System.out.println(total);
        }




    }
}
