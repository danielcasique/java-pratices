package org.casique.commonText;

import org.apache.commons.lang3.StringUtils;

public class commonTextExample {

  public static void main(String[] args) {
    String input = "3/8/24 PROCESSED BY TE\n           \n                 \n4/1/2024   KK   REVISED PO PER PRICE\nTICKET TYPE WAS UPDATED ON ITEM\n\n\n\n4/3/2024   KK   REVISED PO PER PRICE\nTICKET TYPE WAS UPDATED ON ITEM TO 3N\n\n4/8/2024   KK   REVISED PO PER PRICE\nTICKET TYPE WAS UPDATED ON ITEM";
    String result = input.replaceAll("(\\n)+", "\\n");
    System.out.println("Input: \n" + input);
    System.out.println("Result: \n" + result);
  }
}
