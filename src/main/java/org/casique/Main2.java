package org.casique;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Main2 {

  public static void main(String[] args) {
    Integer value = null;
    System.out.println(String.valueOf(value));

    String test = null;
    if("A".equalsIgnoreCase(test)){
      System.out.println("null value 1");
    }
    if(test.equalsIgnoreCase("A")){
      System.out.println("null value 1");
    }
    
  }
}
