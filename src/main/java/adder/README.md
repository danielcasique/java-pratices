## The adder class

There are different kinds of calculators which are available in the market 
for different purposes. Sam wants to make a calculator which can return the sum
of two integers.

Implement the adder class which should follow the following:
- It should inherit from the **Calculator** class.
- It should implement the method ```add(int a, int b)``` which should 
calculate and return the sum of two integers parameters, ```a``` and ```b```.
  
The locked stub code in the editor consists of the following:
- An abstract class named **Calculator** which contains an abstract method 
```add (int a, int b)```
- A solution class which 
    - creates an object of the **adder** class.
    - reads the input and passes them in a method called by the object of the **adder** class.

### Constraints
- 0 < a, b < 10s

### Input format for custom testing
the only line contains tow spaces-separated integers, ```a``` and ```b```.

### Sample case 0
#### Sample input for custom testing
```
1 1 
```
#### Sample output
```
the sum is: 2
```
#### Explanation
When the ```add``` method is called with the arguments a = 1 and b = 1, it 
calculates and returns their sum as 1 + 1 = 2, which is then printed.

### Sample case 1
#### Sample input for custom testing
```
2 3
```
#### Sample output
```
5
```
#### Explanation
When the ```add``` method is called with the arguments a = 2 and b = 3, it
calculates and returns their sum as 2 + 3 = 5, which is then printed.