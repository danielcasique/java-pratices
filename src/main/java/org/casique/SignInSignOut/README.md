## Sign-in Sign-out logs

Application logs are used in analysis of interactions with an application
and may be used to detect specific actions.

A log file is provided as a string array where each entry is in the form
"user_id timestamp action". Each of the values is separated by a space.
- Both user_id and timestamp consist only of digits, are at most 9 digits
long and start with a non-zero digit.
- timestamp represents the time in seconds since the application was last launched.
- action will be either "sign-in" or "sign-out"

Given a log with entries in no particular order, return an array of strings
that denote user_id's of users who signed out in maxSpan seconds or less after
signing in.

**Example++
```
n = 7
logs = ["30 99 sign-in", "30 105 sign-out", "12 100 sign-in", "20 80 sign-in"
"12 120 sign-out", "20 101 sign-out", "21 110 sign-in"]
maxSpan = 20

ID      Sign in         Sign out        Time data
--      --------        ---------       -----------
30      99              105             6
12      100             120             20
20      80              101             21
21      110
```

The users with id's 30 and 12 were not signed in for more than maxSpan = 20 seconds.
In sorted numerical order, the return array is ["12", "30"].

### Sample case 1
#### Sample input
```
STDIN                       FUNCTION
-----                       ---------
4                   ->      logs[] size n = 4
60 12 sign-in       ->      logs = ["60 12 sign-in", "80 20 sign-out", "10 20 sign-in", "0 20 sign-out"]
80 20 sign-out
10 20 sign-in
60 20 sign-out
100                 ->      maxSpan = 100
```
#### Sample output
```
60
```
#### Explanation
```
ID         Sign in          Sign out            Time delta
--         -------          --------            ----------
10          20
60          12                  20                  8
80          20
```
Only user id 60 has signed out and was not signed in for more than maxSpan = 100 seconds. The return array is ["60"].

