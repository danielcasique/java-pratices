package org.casique.JavaStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final List<String> openingCharList = Arrays.asList("{","(");
    private static final List<String> closingCharList = Arrays.asList("}",")");

    public static boolean isBalanced(String value){
        List<String> stack = new ArrayList<>();
        boolean result = true;
        int lastPosition = -1;
        for(int i=0; i< value.length() && result; i++){
            if(stack.isEmpty()){
                lastPosition++;
                stack.add(String.valueOf(value.charAt(i)));
            }else if(closingCharList.contains(String.valueOf(value.charAt(i)))){
                int closingIndex = closingCharList.indexOf(String.valueOf(value.charAt(i)));
                if(openingCharList.get(closingIndex).equals(stack.get(lastPosition))){
                    stack.remove(lastPosition);
                    lastPosition--;
                }else{
                    result = false;
                }
            }else{
                lastPosition++;
                stack.add(String.valueOf(value.charAt(i)));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println(Parser.isBalanced("{}("));
    }
}
