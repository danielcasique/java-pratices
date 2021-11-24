## Java Stack

Given a list of strings of bracket characters: {}(), the string of bracket
is balanced under the following conditions:
1. It is the empty string
2. If strings a and b are balanced, the ab is balanced.
3. If the string a is balanced, then (a) and {a} are balanced.

Write a class that determines whether the brackets in each string are balanced
and returns true if the string is balanced, or false if it is not.

### Example 0
```
s = ["{}()", "{()]", "({()})"]
```
s[0] exhibits condition 2 above. "{}" and "()" are balanced, so "{}()" is
balanced. Return true.  
s[1] exhibits condition 3 above. "()" is balanced, so "{()}" is balanced. Return true.  
s[2] exhibits condition 3 above. "()" is balanced, so "{()]" is balanced and "({()})"
is balanced. Return true.

### Example 1
```
s = ["{}(","({)}", "((", "){"]
```
s[0]: "{}(" is an unbalanced string due to the open "(". Return false.  
s[1]: "({)}" is an unbalanced string due to ")" before "{" has been closed. Return false.  
s[2]: "((" is an unbalanced string because neither "(" is closed. Return false.  
s[3]: "){" is unbalanced string because ")" comes before a "(" and because the final "{" is not closed. Return false.

### Function description

The provided code contains the declaration for a class named Solution with a main method
that does the following:
- Creates a Parser object
- Reads an unknown number of string from stdin
- Parses each string as an argument to the Parser object's isBalanced method and prints value returned by the method on a new line.

Complete the function an isBalanced in the editor below.

isBalanced has the following parameter(s):
- string s: a string characters to check for balance

Returns:  
- bool:a boolean that denotes whether the string is balanced: true if the string is balanced, or false if it is not.


### Constraints
- Each string consists only of the characters {, }, (, and ).
- Each string has fewer than 50 characters.

### Input format for custom testing
Input format stdin will be processed as follows and passed to your Parser.isBalanced method.

Each line contains a string to parse.

### Sample case 0
#### Sample input 0
```
STDIN       FUNTION
-----       --------
{}() ->     s = ['{}()','({()})', '{}(']
({()})
{}(
```
#### Sample output 0
```
true
true
false
```
#### Explanation
- '{}()' contains two adjacent balanced strings. '{}' and '()', so return true
- '({()})' contains a balanced string , '()' nested inside another balanced string, '{}', nested inside another balanced string, '()'. Return true.
- '{}(' contains a balanced string, '{}' followed by an unbalanced string '('. Return false.
