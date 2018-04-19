alphabet = "abcdefghijklmnopqrstuvwxyz"

file = open('input.txt', 'r')

line = file.readline()
while line:
	input = line.split()
	keyLetter = input[0][0]
	count = 1
	output = ""
	for letter in input[1]:
		num = alphabet.index(letter) + alphabet.index(keyLetter)
		if num > 26:
			index = num % 26
			output += alphabet[index]
		else:
			output += alphabet[num]

		keyLetter = input[0][count]
		count += 1
		if count == len(input[0]):
			count = 0

	print(output)
	line = file.readline()