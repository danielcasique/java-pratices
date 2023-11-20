package org.casique;

import com.google.common.base.Joiner;
import java.util.List;
import java.util.StringJoiner;
import org.apache.commons.lang3.StringUtils;

public class Example {

    public final static void main(final String[] args) {
        System.out.println("hola mundo");
        //System.out.println(args[0]);
        //System.out.println(args[1]);

        String test1 = "tst1";
        String test2 = null;
        String test3 = test1 + test2;
        String test4 = StringUtils.join(test1, test2);

        System.out.println(test3); //output "tst1null"
        System.out.println(test4); //output "tst1"


        String test5 = null;
        if(StringUtils.isBlank(test5)){ //null pointer exception
            System.out.println("is empty");
        }
        test5 = "    ";
        if(StringUtils.isBlank(test5)){ //null pointer exception
            System.out.println("is empty");
        }
        test5 = null;
        if(test5.isEmpty()){ //null pointer exception
            System.out.println("is empty");
        }

    }
}
