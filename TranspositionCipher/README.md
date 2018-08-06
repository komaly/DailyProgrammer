A transposition cipher is "a method of encryption by which the positions held by units of plaintext 
(which are commonly characters or groups of characters) are shifted according to a regular system, 
so that the ciphertext constitutes a permutation of the plaintext" (En.wikipedia.org, 2018).

Specifically, this is a route cipher. In a route cipher the text you want to encrypt is written out 
in a grid, and then arranged in a given pattern.

Example:

The text to encrypt is: "WE ARE DISCOVERED. FLEE AT ONCE".

In the input, two numbers will be given as well, which specify the number of rows and columns of the grid.
For this text, there are 3 rows and 9 columns. All punctuation and spaces are stripped, so each space in
the grid is a letter of the text. If the text doesn't fill the grid perfectly, the empty spaces are filled
with an X. For this text, the grid looks like this:

(row1)WEAREDISC
(row2)OVEREDFLE
(row3)EATONCEXX

The encryption and decryption start at the top right of the grid, and spiral in either a clockwise or 
counter clockwise direction. The direction of the spiral is specified in the input as well. The order 
of the letters in the spiral is the newly encrypted message. So for the example above, the encrypted text
for a clockwise spiral is: CEXXECNOTAEOWEAREDISLFDEREV.

This challenge was taken from Reddits Daily Programming Challenge #362, which can be found here:
https://www.reddit.com/r/dailyprogrammer/comments/8n8tog/20180530_challenge_362_intermediate_route/
