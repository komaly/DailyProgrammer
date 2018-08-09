Given 2 numbers, the first number n specifying the number of stacks and the
second number being a string of numbers, each one a box, this program
emits n stacks of boxes, with each stack having the same total size.

Example:
Input: 3 34312332
The first number 3 means that 3 stacks need to be made. Each digit in the 
string of numbers gives each box size.

Output: 331, 322, 34
All digits from the string are used to make 3 stacks, each one with a size
of 7 (i.e. 3 + 3 + 1 = 7, 3 + 2 + 2 = 7, 3 + 4 = 7).

This is a solution to Reddits Daily Programmer Challenge #349, found here:
https://www.reddit.com/r/dailyprogrammer/comments/7ubc70/20180130_challenge_349_intermediate_packing/