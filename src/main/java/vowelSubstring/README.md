## Sales by Match

Given a string of lowercase English letters and an integer of the substring
length, determine the substring of that length that contains the most vowels.
Vowels are in the set ```{a, e, i, o, u}```. If there is more than one substring 
with the maximum number of vowels, return the one that starts at the lowest index.
If there are no vowels in the input string, return the string 'Not found!' 
without quotes.

**Example 1**
```
s = 'caberqiitefg'
k = 5
```
The substring of the length ```k = 5``` that contains the maximum number of vowels
is ```erqii``` with 3 vowels.
The final answer is ```erqii```

**Example 2**
```
s = 'aeiouia'
k = 3
```

All the characters are vowels, so any substring of length 3 will have vowels.
The lowest index substring is at index 0, ```aei```

### Function description
Complete the function ```findSubstring``` in the editor below.

```findSubstring``` has the following parameters:
- s: a string
- k: an integer

### Constraints
- 1 <= length(s) <= 2 * 10^5
- 1 <= k <= length

### Input format for custom testing
The first line contains a string, ```s```.
the second linde contains an integer, ```k```.

### Sample Case 0
#### Sample input
```
STDIN           FUNCTION
------          ----------
azedii  ->      s = 'azerdii'
5       ->      k = 5
```
#### Sample output
```
erdii
```

#### Explantion
```
s='azerdii'
k=5
```
The posible 5 characters substrings are:
- 'azerd' which contains 2 vowels.
- 'zerdi' which contains 2 vowels.
- 'erdii' which contains 3 vowlels

The final answer is ```erdii```.