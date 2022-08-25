package PalindromeChecker;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class PalindromeChecker {

    /*
     * Complete the 'palindromeChecker' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndex
     *  3. INTEGER_ARRAY endIndex
     *  4. INTEGER_ARRAY subs
     */
    public static String palindromeCheckerV2(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        // Write your code here
        StringBuffer result = new StringBuffer();
        int sizeStartIndex = startIndex.size();
        int sizeEndIndex = endIndex.size();
        int size = (sizeStartIndex <= sizeEndIndex)? sizeStartIndex :  sizeEndIndex;
        for(int i=0; i < size; i++){
            if(i<startIndex.size() && i<endIndex.size() && startIndex.get(i)<=endIndex.get(i)){
                StringBuilder subStr = new StringBuilder(s.substring(startIndex.get(i), (endIndex.get(i) + 1)));
                StringBuilder comp = new StringBuilder(s.substring(startIndex.get(i), (endIndex.get(i) + 1))).reverse();
                if(comp.toString().equals(subStr.toString())){
                    result = result.append("1");
                }else if(i<subs.size() && subs.get(i)>0){
                    int nroSubs = subs.get(i);
                    //make substitutions
                    Map<String, Long> charCount = subStr.chars()
                            .mapToObj(Character::toString)
                            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                    Integer pairsNeeded = subStr.length() / 2;
                    Long existingParis = charCount.values().stream().mapToLong(x -> x/2).sum();
                    result.append(((pairsNeeded - existingParis) <=  nroSubs) ? "1" : "0");
                }else{
                    //there is no subs and the substr it's not palindrome
                    result = result.append("0");
                }
            }else{
                //there is no way to get a substring
                result = result.append("0");
            }
        }

        return result.toString();
    }
    public static String palindromeChecker(String s, List<Integer> startIndex, List<Integer> endIndex, List<Integer> subs) {
        // Write your code here
        StringBuffer result = new StringBuffer();
        int sizeStartIndex = startIndex.size();
        int sizeEndIndex = endIndex.size();
        int size = (sizeStartIndex <= sizeEndIndex)? sizeStartIndex :  sizeEndIndex;
        for(int i=0; i < size; i++){
            if(i<startIndex.size() && i<endIndex.size() && startIndex.get(i)<=endIndex.get(i)){
                StringBuilder subStr = new StringBuilder(s.substring(startIndex.get(i), (endIndex.get(i) + 1)));
                StringBuilder comp = new StringBuilder(s.substring(startIndex.get(i), (endIndex.get(i) + 1))).reverse();
                if(comp.toString().equals(subStr.toString())){
                    result = result.append("1");
                }else if(i<subs.size() && subs.get(i)>0){
                    int nroSubs = subs.get(i);
                    //make substitutions
                    Map<String, Long> charCount = s.chars()
                                                .mapToObj(Character::toString)
                                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                    Integer pairsNeeded = s.length() / 2;
                    Long existingParis = charCount.values().stream().mapToLong(x -> x/2).sum();
                    //
                    boolean isPalindrome = false;
                    for(int k1=0; k1<nroSubs && !isPalindrome; k1++){
                        //cycle for each number of substitutions
                        int changes = 0;
                        int leftIndex = 0;
                        int rightIndex = subStr.length() - 1;
                        StringBuilder subStr2 = new StringBuilder(subStr);
                        while(true){
                            //cycle can stop after applying all changes / there is no more possible changes / find a palindrome
                            if(subStr2.charAt(leftIndex) != subStr2.charAt(rightIndex)){
                                subStr2.setCharAt(rightIndex, subStr2.charAt(leftIndex));
                                changes+=1;
                                comp = new StringBuilder(subStr2).reverse();
                                if(subStr2.toString().equals(comp.toString())){
                                    result = result.append("1");
                                    isPalindrome = true;
                                    break;
                                }else if(changes == k1+1){
                                    changes = 0;
                                    subStr2 = new StringBuilder(subStr);
                                }
                                leftIndex+=1;
                                rightIndex-=1;
                                if(leftIndex>=rightIndex){
                                    break;
                                }
                            }
                        }
                    }
                    if(!isPalindrome){
                        result = result.append("0");
                    }
                }else{
                    //there is no subs and the substr it's not palindrome
                    result = result.append("0");
                }
            }else{
                //there is no way to get a substring
                result = result.append("0");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int startIndexCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startIndex = IntStream.range(0, startIndexCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int endIndexCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> endIndex = IntStream.range(0, endIndexCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int subsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> subs = IntStream.range(0, subsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        String result = PalindromeChecker.palindromeChecker(s, startIndex, endIndex, subs);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
