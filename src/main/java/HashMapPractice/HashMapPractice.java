package HashMapPractice;

import lombok.Data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
class MyClass{
    String key;

    public MyClass(String key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object obj) {
        if(Objects.isNull(key))
            return false;
        if(Objects.nonNull(obj) && (obj instanceof MyClass)){
            MyClass value = (MyClass) obj;
            if(Objects.nonNull(value.getKey()) && value.getKey().equals(key)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
@Data
class Product {

    private String name;
    private String description;
    private List<String> tags;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product addTagsOfOtherProduct(Product product) {
        this.tags.addAll(product.getTags());
        return this;
    }
}

public class HashMapPractice {

    public static void main(String[] args) {
        MyClass example1 = new MyClass("key1");
        MyClass example2 = new MyClass("key2");
        MyClass example3 = new MyClass("key1");
        Map<MyClass, String> map = new HashMap<>();

        Map<String, String> map2 = new HashMap<>();

        map.put(example1, "A");
        map.put(example2, "B");
        System.out.println(map.get(example3));

        String key1 = "A";
        String key2 = "A";
        map2.put(key1, "A");
        map2.put(key2, "B");

        StringBuffer keyB1 = new StringBuffer("A");
        StringBuffer keyB2 = new StringBuffer("A");
        Map<StringBuffer, String> map3 = new HashMap<>();
        map3.put(keyB1, "A");
        map3.put(keyB2, "B");


        System.out.println(map2);
        System.out.println(map3);
        keyB1 = keyB1.append("-A");
        System.out.println(map3);
        System.out.println(map3.get(new StringBuffer("A-A")));

        Map<String, Product> productsByName = new HashMap<>();
        Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
        Product eBike = new Product("E-Bike", "A bike with a battery");
        productsByName.put(null, defaultProduct);
        productsByName.put(null, eBike);

        Product nextPurchase = productsByName.get(null);
        System.out.println(nextPurchase);

    }

}
