package org.casique;

import static java.util.UUID.nameUUIDFromBytes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

//Wrapper classes Integer

//SOLID
//Liskov Substitution

//thread-safe
//lazy-loaded
//@autowired
//

interface Animal{

}

class Perro implements Animal{

}

class Gato implements Animal{

}

class test{
  private List<String> lista;
  private Integer value;

  //perro / gato
  public void procesar(Animal animal){

  }

}

public class Main2 {

  public static void main(String[] args) {

    String id = nameUUIDFromBytes(
        "scsp-ingress-inventory-api-v1-ops-costuming-by-dlr-inventory-receipt-confirmation-1732098981899"
            .getBytes())
        .toString();
    System.out.println("id = " + id);
    //Float testF;
    //BigDecimal testBD= BigDecimal.valueOf(testF.doubleValue());

    Integer value = null;
    System.out.println(String.valueOf(value));

    String test = null;
    if("A".equalsIgnoreCase(test)){
      System.out.println("null value 1");
    }
    if(test.equalsIgnoreCase("A")){
      System.out.println("null value 1");
    }

    Map<String, String> map = new HashMap<>();
    map.put("clave-1","valor-1");
    map.put("clave-1","valor-2");
    List<String> test1 = new ArrayList<>();
    List<String> test2 = new LinkedList<>();
    test2.add("daniel");
    test2.get(1);


  }
}
