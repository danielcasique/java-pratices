## New Year Chaos

For two integers arrays, the comparator value es the total number of elements in the first array such that there exists no integer in the second array with an absolute difference less than or equal to d. Find the comparator value.

For Example there are two arrays a = [7,5,9], b=[13,1,4], and the integer d=3. The absolute difference of a[0] to b[0] = |7-13| = 6, b[1] = |7 -1| = 6, and b[2] = |7-4| = 3, to recap, the values are 6,6,3. In this case, the absolute difference with b[2] is equal to d=3, so this element  does not meet the criterion. A similar analysis of a[1] = 5 yields absolute difference with each element of b that is always greater than d is element a[2], thus the comparator value is 1.

### Function Description

Complete the function comparatorValue in the editor below. The function must return an integer that denotes the comparator value of the arrays.

comparatorValue has the following parameter(s):
- a[a[0],...a[n-1]]: an array of integers 
- b[b[0],...b[m-1]]: an array of integers
- d: an integer

### Constraints
- 1 <= n, m <= 10^5
- 0 <= a[i], b[j], d <= 10^8

### Input Format

The first line contains an integer, ```n```, the number of elements in ```a```.
Each line ```i``` of the ```n``` subsequent lines (where 0 <= i < n) contains an integer, a[i].  
The next line contains an integer, ```m```, the number of elements in ```b```.
Each line ```j``` of the subsequent lines (where 0 <= j < m) contains an integer, b[j].  
The las line contains an integer, ```d```, that denotes the maximum allowed absolute difference in the values of the elements.

### Sample case 0
```
3
3
1
5
3
5
6
7
2
```
### Explanation
The first array a=[3,1,5], the second array b=[5,6,7], and d=2. Now find the absolute difference of each element of the first array with the elements of the second array:
- For a[0]=3, the differences are a[0] - b[0] = 3 - 5 = -2, a[0] - b[1] = 3 - 6 = -3, and a[0] - b[2] = 3 - 7 = -4. Therefore, the absolute differences are [2,3,4]. For a[0] = 3, there exists at least one integer in the second array with absolute difference less than or equal to d = 2.
- For a[1]=1, the differences are a[1] - b[0] = 1 - 5 = -4, a[1] - b[1] = 1 - 6 = -5, and a[1] - b[2] = 1 - 7 = -6. Therefore, the absolute differences are [4,5,6]. for a[1] = 1, there exists no integer in the second array with absolute differences less than or equal to d = 2.
- For a[2]=5, the differences are a[2] - b[0] = 5 - 5 = 0, a[2] - b[1] = 5 - 6 = -1, and a[2] - b[2] = 5 - 7 = -2. Therefore, the absolute differences are [0,1,2]. For a[2] = 5, there exists at least one integer in the second array with absolute differences less than or equal to d=2.

The comparator value 1.