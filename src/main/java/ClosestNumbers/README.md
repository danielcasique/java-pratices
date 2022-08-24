## Closest Numbers

Given an array of distinct integers, determine the minimum absolute difference between any two elements. Print all element pairs with that difference in ascending order.

#### Example
*numbers=[6,2,4,10]*
The minimum absolute difference is *2* and the pairs with that difference are *(2,4)* and *(4,6)*. When printing element pairs *(i,j)*, they should be ordered ascending first by *i* and then by *j*.
```
2 4
4 6
```

### Function Description
Complete the function *closestNumbers* in the editor.

*closestNumbers* has the following parameter(s):
  - *int numbers[n]*: an array of intergers

#### Returns
NONE

#### Prints
distinct elements pairs that share the minimum absolute difference, displayed in ascending order with each pair separated by one space on a single line.

### Constraints

- *2 <= n <= 10^5*
- *-10^9 <= numbers[i] <= 10^9*

## Input format for custom testing
Input from stdin will be processed as follows and passed to the function.

The first line contains an integer *n*,the size of the array numbers. Each of the next *n* lines contains an integer, *numbers[i]*.

### Sample case 0
#### Sample input 0
```
STDIN         FUNCTION
_____         _________
4           -> numbers[] size n = 4
4           -> numbers = [4, 2, 1, 3]
2
1
3
```
#### Sample output 0
```
1 2
2 3
3 4
```
#### Explanation
the minimum absolute difference between any two elements in the array is 1, and there are three such pairs with this difference:
*(1,2)*,*(2,3)*, and *(3,4)*.

### Sample case 1
#### Sample input 1
```
STDIN         FUNCTION
_____         _________
4           -> numbers[] size n = 4
4           -> numbers = [4, -2, -1, 3]
-2
-1
3
```
```
#### Sample output 0
```
-2 -1
3 4
```
#### Explanation
the minimum absolute difference between any two elements in the array is 1, and there are two such pairs *(-2,-1)*, and *(3,4)*.