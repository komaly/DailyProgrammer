
def cipher(filename, type):
	try:
		file = open(filename, 'r')
	except:
		print("Error opening file.")
		return

	alphabet = "abcdefghijklmnopqrstuvwxyz"

	line = file.readline()
	while line:
		input = line.split()
		keyLetter = input[0][0]
		count = 1
		output = ""
		for letter in input[1]:
			if type == "encrypt":
				num = alphabet.index(letter) + alphabet.index(keyLetter)
			elif type == "decrypt":
				num = alphabet.index(letter) - alphabet.index(keyLetter)
			else:
				print("Invalid request.")
				return

			if num > 25 or num < 0:
				output += alphabet[num % 26]
			else:
				output += alphabet[num]

			keyLetter = input[0][count]
			count += 1
			if count == len(input[0]):
				count = 0

		
		if type == "encrypt":
			print("Original: " + input[1] + "\nEncrypted: " + output + "\n")
		if type == "decrypt":
			print("Original: " + input[1] + "\nDecrypted: " + output + "\n")

		line = file.readline()

print("Encrypted Phrases")
cipher("input.txt", "encrypt")
print("\n")
print("Decrypted Phrases")
cipher("decryptor_input.txt", "decrypt")