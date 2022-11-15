package org.casique.SignInSignOut;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



/**
 * The type Log entry.
 */
class LogEntry{

    private int logInTime;
    private int logOutTime;

    /**
     * Gets log in time.
     *
     * @return the log in time
     */
    public int getLogInTime() {
        return logInTime;
    }

    /**
     * Sets log in time.
     *
     * @param logInTime the log in time
     */
    public void setLogInTime(int logInTime) {
        this.logInTime = logInTime;
    }

    /**
     * Gets log out time.
     *
     * @return the log out time
     */
    public int getLogOutTime() {
        return logOutTime;
    }

    /**
     * Sets log out time.
     *
     * @param logOutTime the log out time
     */
    public void setLogOutTime(int logOutTime) {
        this.logOutTime = logOutTime;
    }

    /**
     * Gets result.
     * Negative number when sign-in or sign-out are missing
     * @return the result
     */
    public int getResult() {
        int result = this.logOutTime - this.logInTime;
        if(this.logOutTime == 0 || this.logInTime == 0){
            result = -1;
        }
        return result;
    }

}


/**
 * The type Result.
 */
class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER maxSpan
     */
    private final static int MIN_SPAN = 0;
    private final static int MAX_SPAN = 1000000000;
    private final static int MIN_TIMESTAMP = 0;
    private final static int MAX_TIMESTAMP = (int)Math.pow(10,9);

    /**
     * Validate entry.
     *
     * @param minValue the min value
     * @param maxValue the max value
     * @param value    the value
     */
    public static void validateEntry(int minValue, int maxValue, int value){
        if(value < minValue || value > maxValue){
            throw new IllegalArgumentException(
                    String.format("The value %d must be between %d and % d", value, minValue, maxValue)
            );
        }
    }

    /**
     * Process logs list.
     *
     * @param logs    the logs
     * @param maxSpan the max span
     * @return the list
     */
    public static List<String> processLogs(List<String> logs, int maxSpan) {
        // Write your code here

        List<String> result;
        Map<String, LogEntry> logProcessingList = new HashMap<>();

        //Validate the maxSpan parameter
        validateEntry(MIN_SPAN, MAX_SPAN, maxSpan);
        //Validate the logs size parameter
        validateEntry(MIN_SPAN, MAX_SPAN, logs.size());
        validateEntry(MIN_SPAN, MAX_SPAN, maxSpan);

        for(String value : logs){
            String[] logParts = value.split(" ");
            if(logParts.length != 3){
                throw new IllegalArgumentException("The log entries are invalid");
            }

            LogEntry nValue = logProcessingList.get(logParts[0]);
            int nTimestamp = Integer.parseInt(logParts[1]);
            validateEntry(MIN_TIMESTAMP, MAX_TIMESTAMP, nTimestamp);
            if(nValue == null){
                nValue = new LogEntry();
            }
            if("sign-in".equalsIgnoreCase(logParts[2])){
                nValue.setLogInTime(nTimestamp);
            }else{
                nValue.setLogOutTime(nTimestamp);
            }
            logProcessingList.put(logParts[0], nValue);
        }

        result = logProcessingList
                .entrySet()
                .stream()
                .filter( e -> e.getValue().getResult() <= maxSpan && e.getValue().getResult() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
                .stream()
                .sorted((t1, t2) -> (Integer.valueOf(t1) - Integer.valueOf(t2)))
                .collect(Collectors.toList());


        return result;
    }

}

public class SignInSignOut {
    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int maxSpan = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.processLogs(logs, maxSpan);

        result.forEach(System.out::println);
        /*
        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
