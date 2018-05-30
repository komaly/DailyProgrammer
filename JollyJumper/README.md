This challenge determines whether a sequence of numbers is a jolly jumper.

A sequence of n > 0 integers is called a jolly jumper if the absolute values of the differences 
between successive elements take on all possible values through n - 1 (which may include negative 
numbers). For instance,

1 4 2 3

is a jolly jumper, because the absolute differences are 3, 2, and 1, respectively. The definition 
implies that any sequence of a single integer is a jolly jumper.

Given an input such as 4 1 4 2 3, where the first number describes the total number of elements there
are in the sequence, determine whether the given sequence is a jolly jumper or not.

This is an answer to Reddit's Daily Programmer Challenge #311, located at:
https://www.reddit.com/r/dailyprogrammer/comments/65vgkh/20170417_challenge_311_easy_jolly_jumper/