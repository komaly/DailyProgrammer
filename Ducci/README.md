A Ducci sequence is a sequence of n-tuples of integers, sometimes known as "the Diffy game", 
because it is based on sequences. Given an n-tuple of integers (a_1, a_2, ... a_n) the next 
n-tuple in the sequence is formed by taking the absolute differences of neighboring integers. 

Some Ducci sequences descend to all zeroes or a repeating sequence. An example is 
(1,2,1,2,1,0) -> (1,1,1,1,1,1) -> (0,0,0,0,0,0)

Given an n tuple, this program prints the Ducci sequence for the 
n tuple and prints the number of steps taken to get to the end of the sequence.

Example:

Input:(0, 653, 1854, 4063)

Output: 

0 653 1854 4063

653 1201 2209 4063

548 1008 1854 3410

460 846 1556 2862

386 710 1306 2402

324 596 1096 2016

272 500 920 1692

228 420 772 1420

192 352 648 1192

160 296 544 1000

136 248 456 840

112 208 384 704

96 176 320 592

80 144 272 496

64 128 224 416

64 96 192 352

32 96 160 288

64 64 128 256

0 64 128 192

64 64 64 192

0 0 128 128

0 128 0 128

128 128 128 128

0 0 0 0

24 steps


This program answers Reddits Daily Programming Challenge #364, found here:
https://www.reddit.com/r/dailyprogrammer/comments/8sjcl0/20180620_challenge_364_intermediate_the_ducci/


