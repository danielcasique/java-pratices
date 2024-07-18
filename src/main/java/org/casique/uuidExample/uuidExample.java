package org.casique.uuidExample;

import java.util.UUID;

public class uuidExample {

  public static void main(String[] args) {
    String id1 = UUID.nameUUIDFromBytes(
            String.valueOf(10100558).concat("1").getBytes())
        .toString();
    System.out.println("id source=1 => " + id1);
    String id2 = UUID.nameUUIDFromBytes(
            String.valueOf(10100558).concat("0001").getBytes())
        .toString();
    System.out.println("id source=0001 => " + id2);

  }

}
