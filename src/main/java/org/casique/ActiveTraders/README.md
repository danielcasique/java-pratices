## Active Traders
An institutional broker wants to review their book of customers to see which are most active. Given a list of trades by customer name, determine which customers account for at least 5% of the total number of trades. Order the list alphabetically ascending by name.

### Example:
n=23  
customers = ["Bigcorp", "Bigcorp", "Acme", 
"Bigcorp", "Zork", "Zork", "Abc", "Bigcorp", 
"Acme", "Bigcorp", "Bigcorp", "Zork", "Bigcorp",
"Zork", "Zork", "Bigcorp", "Acme", "Bigcorp",
"Acme", "Bigcorp", "Acme", "LittleCorp",
"Nadircorp"]  

Bigcorp had 10 trades out of 23, which is 43.48% of the total trades.  
Both Acme and Zork has 5 trades, which is 21.74% of the total trades.  
The Litllecorp, Nadir, and Abc had 1 trade each, which is 4.35% of the total trades.  
So the answer is ["Acme", "Bigcorp", "Zork"] (in alphabetical order) because only these three companies placed at least 5% of trades.

### Function Description
Complete the function mostActive in the editor below.  

mostActive has the following parameter:  
- string customers[n]: an array customer names

### Returns
- string[]: an alphabetical ascending array of customer names.

### Constraints
- 1 <= n <= 10^5
- 1 <= length of the customers[i] <= 20
- The first character of customers[i] is a capital English letter
- All characters of customers[i] except for the first one are lowercase English letter.
- It is guaranteed that at least one customer makes at least 5% of trades.

### Input format for custom testing
The first line contains an integer, n, the number of elements in customers. Each line i of the n subsequent lines (where 0 <= i < n) contains a string, customers[i].

### Sample Case 0
```
STDIN          Function
-----          --------
20        ->   customers[] size n = 20
Omega     ->   customers = ["Omega", "Alpha", "Omega", ..., "Beta"].
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Omega
Alpha
Alpha
Beta
```
#### Sample Output
```
Alpha
Beta
Omega
```
####  Explanation
Alpha made 10 trades out of 20 (50% of the total), Omega made 9 trades (45% of the total) and Beta made 1 trade (5% of the total). All of them have met the 5% threshold, so all the strings are returned in an alphabetically ordered array.

### Sample Case 2
```
STDIN          Function
-----          --------
21        ->   customers[] size n = 21
Alpha     ->   customers = ["Alpha", "Beta", "Zeta", ..., "Beta"]
Beta
Zeta
Beta
Zeta
Zeta
Epsilon
Beta
Zeta
Beta
Zeta
Beta
Delta
Zeta
Beta
Zeta
Beta
Zeta
Beta
Zeta
Beta
```
#### Sample Output
```
Beta
Zeta
```
####  Explanation
Both Beta and Zeta made 9 trades out of 21 (42.86% of the total). Alpha, Delta and Epsilon made 1 trade each, which is only 4.76% of the total number of trades. Only Beta and Zeta meet the threshold.











