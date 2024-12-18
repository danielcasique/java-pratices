package org.casique.numberTransformation;

import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class NumberTransformation {

  public static Number getNumber(String value){
    if(StringUtils.isEmpty(value)){
      return null;
    }

    if(!StringUtils.isNumeric(value)){
      //log the error
      System.out.println("Invalid Value");
      return null;
    }

    return NumberUtils.createNumber(value);
  }

  public static void main(String[] args) {



    Optional<Integer> val;
    try {
      String value = null;
      val = Optional.of(Integer.parseInt(value));
    } catch (NullPointerException | NumberFormatException exception) {
      System.out.println(exception.getMessage());
      val = Optional.empty();
    }

    try {
      String value = "ads";
      val = Optional.of(Integer.parseInt(value));
    } catch (NullPointerException | NumberFormatException exception) {
      System.out.println(exception.getMessage());
      val = Optional.empty();
    }

    String value = "abd";
    System.out.println(getNumber(value).intValue());
  }
}
