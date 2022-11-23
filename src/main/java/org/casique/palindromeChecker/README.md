## Can you make a Palindrome

A function receives a string s and a series of queries. For each query, there will be a beginning and ending index and a number of substitutions. A palindrome is a string spelled the same way forward or backward, like a, mom or abba. For each substring represented by the begining and ending index of the string s, determine if it is possible to rearrange it to a palindrome after performing up to the given number of substitutions.

Start with an empty result string. After each query, append a *1* or *0* to indicate whether the substring can be converted to a palindrome. A *1* represents *yes* and a *0* represents *no*. Return the results string after all queries have been processed. 

#### Example
```
s = cdecd
startIndex = [0,0,0,0]
endIndex = [0,1,2,3]
subs = [0,1,1,0]
```
- Query 1: s[0,0] = 'c', subs[0] = 0. The substring 'c' is a palindrome after 0 substitutions, so result='1'.
- Query 2: s[0,1] = 'cd', subs[1] = 1. Change 'c' to 'd' or 'd' to 'c' in 1 substitution to make a palindrome 'dd' or 'cc', so result = '11'.
- Query 3: s[0,2] = 'cde', subs[2] = 1. Change 'c' to 'e' or 'e' to 'c' in 1 substitution to make a palindrome 'cdc' or 'ede', so result = '111'
- Query 4: s[0,3] = 'cdec', subs[3] = 0. The string cannot be rearranged into a palindrome with 0 substitutions, so result = '1110'.

#### Example
```
s = 'xxdnssuqevu'
startIndex = [0]
endIndex = [10]
subs = [3]
```
There is one query that looks at the entire string and allows up to 3 substitutions. One way to create a palindrome is to replace q and e with d and n, then rearrange the string. After the replacement, the string s = 'xsudnvndusx'. The result string to return is '1'.

### Function Description
Complete the function *palindromeChecker* in the editor below.

*palindromeChecker* has the following parameters:
- *string s*: the working string
- *int startIndex[q]*: an array of integers that denotes the right index of each substring tor process.
- *int endIndex[q]*: an array of integers that denotes the right index of each substring to process
- *int subs[q]* an array of integers that denotes the number of character substitutions that may occur.
- Returns:
  - *string*:a string where each position represents the results of a query, *1* if a palindrome can be formed, or *0* if not.

#### Constraints
- 1 <= length of the given string <= 100000
- s contains only lowercase letters, ascii[a-z]
- 1 <= q <= 100000
- 0 <= startIndex[i], endIndex[i] < length of s
- startIndex[i] <= endIndex[i]
- 0 <= subs[i] <= length of s[startIndex[i]:endIndex[i]]

### Input Format for custom testing
Input from stind will be processed as follows and passed to the function.

- The first line contains a string s, the working string.
- The next line contains an integer q, the size of the startIndex array.
- The next q lines each contain an element startIndex[i] where 0<= i < q.
- The next line contains an integer q, the size of the endIndex array.
- The next q lines each contain an element endIndex[i] where  0<= i < q.
- The next line contains an integer q, the size of the subs array
- The next q lines each contain an element subs[i] where 0 <= i < q.

### Sample case 0
#### Sample input
```
STDIN         FUNCTION
_____         _________
bcba        -> s = "bcba"
3           -> startIndex[] size q = 3
1           -> startIndex = [1, 2, 1 ]
2
1
3           -> endIndex[] size q = 3
3           -> endIndex = [3, 3, 1]
3
1
3           -> subs[] size q = 3
2           -> subs = [2, 0, 0]
0
0 
```
#### Sample input
```
101
```
#### Explanation
```
s = "bcba"
q = 3
startIndex = [1,2,1]
q = 3
endIndex = [3,3,1]
q = 3
subs = [2,0,0]
```
- query 0, s[1,3], subs[0] = 2, the substring is "cba". Up to two characters can be changed to make it "cbc" or "bbb", etc. A palindrome can be formed.
- query 1, s[2,3], subs[1] = 0, the substring is "ba" with subs = 0, nothing can be changed, thus this is not a palindrome.
- query 2, s[1,1], subs[2] = 0, the substring is "c". It is already a palindrome.

The bit string is 101.

### Sample case 1
#### Sample input
```
STDIN         FUNCTION
_____         _________
bcba        -> s = "cbac"
3           -> startIndex[] size q = 3
0           -> startIndex = [0, 2, 1 ]
2
1
3           -> endIndex[] size q = 3
3           -> endIndex = [3, 3, 3]
3
3
3          -> subs[] size q = 3
0           -> subs = [0,2,2]
2
2
```
#### Sample input
```
011
```
#### Explanation
```
s = "cbac"
q = 3
startIndex = [0,2,1]
q = 3
endIndex = [3,3,3]
q = 3
subs = [0,2,2]
```
- query 0, s[0,3], subs[0] = 0, the substring is "cbac". Nothing can be changed, thus this is not palindrome.
- query 1, s[2,3], subs[1] = 2, the substring is "ac" with subs = 0. 1 character can be changed to make it "aa", which is palindrome. It does not require as many changes as are available
- query 2, s[1,3], subs[2] = 2 ths substring is "bac". 1 character can be changed to make it "bab" which is a palindrome.

The bit string is 011.

### Sample case 2
#### Sample input
```
STDIN         FUNCTION
_____         _________
bcba        -> s = "bcbab"
3           -> startIndex[] size q = 3
1           -> startIndex = [1, 1, 2 ]
1
2
3           -> endIndex[] size q = 3
4           -> endIndex = [4, 3, 3]
3
3
3          -> subs[] size q = 3
3           -> subs = [3,3,0]
3
0
```
#### Sample input
```
110
```
#### Explanation
```
s = "bcbab"
q = 3
startIndex = [1,1,2]
q = 3
endIndex = [4,3,3]
q = 3
subs = [3,3,0]
```
- query 0, s[1,4], subs[0] = 3, the substring is "cbab". 3 characters can be changed to make it "cccc", which is palindrome
- query 1, s[1,3], subs[1] = 3, the substring is "cba". 3 characters can be changed to make it "ccc", which is palindrome.
- query 2, s[2,3], subs[2] = 0 ths substring is "ba". Nothing can be changed and it is not already palindrome.

The bit string is 110.
