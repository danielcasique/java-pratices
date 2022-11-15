## Restocking th Warehouse

A purchasing manage must buy a specific number of units of an item to 
replenish the warehouse. The primary supplier has a list of containers, 
each with a number of units. The manager must buy contiguous containers, 
starting at container 0 and continuing until at least the desired number 
have been purchased. If there are not enough units available, they must be 
purchased from an additional supplier. If any excess items must be purchased,
there is no room for storage, and they must be resold. Determine the 
remaining number of items to be purchased, or the number that must be sold 
after the purchase from the primary supplier.

For Example, there are containers with itemCount = [10,20,30,40,15]. If the
target quantity target = 80, the manager will start buying at index 0 and continue
until all available units are purchased or until at least 80 units have been 
purchased. The manager will buy containers with 
itemCounts = 10 + 20 + 30 + 40 = 100. In this case, the number sold is 
purchased - target = 100 - 80 = 20 units. If the goal is target = 130, the 
manager will purchase all the units for a total of purchases = 115, and an 
additional target - purchase = 130 - 115 = 15  additional units to purchase.

### Function Description
Complete the function restock in the editor below. The function must return the 
number of units the manager needs to return if he/she exceeds the pre-decided 
amount, or the additional units needs to be bought in order to reach the 
pre-decided goal.

restock has the following parameter(s):
- itemCount[itemCount[0],...itemCount[n-1]]: an array of integers that denote the
item counts of each container in the order the must be purchased.
- target: an integer that denotes the target number of items needed.

### Constraints
- 1 <= n <= 10^5
- 1 <= target <= 10^9
- 1 <= itemCount[i] <= 10^9

### Input format for custom testing
The first line contains an integer, ```n```, the number of items needed.  
Each line ```i``` of the ```n``` subsequent lines (where 0 <= i <= n) contains
an integer, itemCount[i], the item count in the i^th container.  
the next line contains an integer, ```target```, the target number of items needed.

### Sample case 0

#### Sample input for custom testing
```
4
6
1
2
1
100
```

#### Sample output
```
90
```

#### Explanation
the number of items available at the primary supplier is 6 + 1 + 2 + 1 = 10,
and target = 100 units. The manager must buy 100 - 10 = 90 additional units.

### Sample case 1

#### Sample input for custom testing
```
5
1
2
3
2
1
4
```

#### Sample output
```
2
```

#### Explanation
The number of items in the first 3 containers is 1 + 2 + 3 = 6, and target = 4
units. The purchasing manager must sell 6 - 4 = 2 units.