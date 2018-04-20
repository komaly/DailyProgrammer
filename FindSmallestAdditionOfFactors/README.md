This is an answer to a Daily Programmer question. Read the full problem at: 
https://www.reddit.com/r/dailyprogrammer/comments/83uvey/20180312_challenge_354_easy_integer_complexity_1/

Given a number A, find the smallest possible value of B+C, if B*C = A. A, B, and C must all be positive integers. 

For instance, given A = 12345 you should return 838. Here's why. There are four different ways to represent 12345 as 
the product of two positive integers:

12345 = 1*12345
12345 = 3*4115
12345 = 5*2469
12345 = 15*823

The sum of the two factors in each case is:
1*12345 => 1+12345 = 12346
3*4115 => 3+4155 = 4158
5*2469 => 5+2469 = 2474
15*823 => 15+823 = 838

The smallest sum of a pair of factors in this case is 838.

Examples:
12 => 7
456 => 43
4567 => 4568
12345 => 838

