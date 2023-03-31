package org.casique.oop.composition;

import java.util.ArrayList;
import java.util.List;

class College {
    public String name;
    public String address;
    College(String name, String address)
    {
        this.name = name;
        this.address = address;
    }
}

public class University {

    private final List<College> colleges;
    University(List<College> colleges)
    {
        this.colleges = colleges;
    }

    public List<College> getTotalCollegesInUniversity()
    {
        return colleges;
    }

    public static void main(String[] args)
    {
        // Creating the Objects of College class.
        College c1
                = new College("ABES Engineering College", "Ghaziabad");
        College c2
                = new College("AKG Engineering College", "Ghaziabad");
        College c3 = new College("ACN College of Engineering & Management Sudies",
                "Aligarh");
        // Creating list which contains the no. of colleges.
        List<College> college = new ArrayList<College>();
        college.add(c1);
        college.add(c2);
        college.add(c3);
        University university = new University(college);
        List<College> colleges = university.getTotalCollegesInUniversity();
        for (College cg : colleges) {
            System.out.println("Name : " + cg.name
                    + " and "
                    + " Address : " + cg.address);
        }
    }
}
