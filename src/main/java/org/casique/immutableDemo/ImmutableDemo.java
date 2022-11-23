package org.casique.immutableDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ImmutableDemo {
    final String studentName;
    final int rollNumber;
    final Date birthDate;
    public ImmutableDemo  (String studentName, int rollNumber, Date birthDate) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.birthDate = (Date) birthDate.clone();
    }
    public String getStudentName() {
        return studentName;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public Date getBirthDate() {
        return (Date)birthDate.clone();
    }
    public static void main(String[] args) throws Exception {
        String birthDate= "31/09/1997";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        ImmutableDemo obj = new ImmutableDemo  ("John" , 100, date);
        System.out.println("Name is " + obj.getStudentName());
        System.out.println("Roll Number is " + obj.getRollNumber());
        System.out.println("Birth date is " + obj.getBirthDate());
        obj.getBirthDate().setTime(1000);
        System.out.println("After changing birth date>>>>>>>>>>>>");
        System.out.println("Name is " + obj.getStudentName());
        System.out.println("Roll Number is " + obj.getRollNumber());
        System.out.println("Birth date is " + obj.getBirthDate());
        //changing date
        date.setTime(1000);
        System.out.println("After changing birth date>>>>>>>>>>>>");
        System.out.println("Name is " + obj.getStudentName());
        System.out.println("Roll Number is " + obj.getRollNumber());
        System.out.println("Birth date is " + obj.getBirthDate());
    }
}
