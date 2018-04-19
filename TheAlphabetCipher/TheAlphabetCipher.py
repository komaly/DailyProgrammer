'''

Encrypt and Decrypt functions for the Vigenere Cipher
Answer to Reddit's Daily Programmer Challenge #355 
(Modified to include capital letters and other characters as inputs)

'''
#Return's a character's index in a shifted ASCII alphabet
def charToCode(char):
	o = ord(char)

	if o < 32 or o > 126:
		return 0

	return o - 32

#Returns a character from an index in a shifted ASCII alphabet
def codeToChar(code):
	return chr(code + 32)

#Encrypt text character by character
def encrypt(secretWord, plainText):
	output = ""
	keyIndex = 0
	for letter in plainText:

		#Add corresponding key character to encrypted output
		output += codeToChar((charToCode(letter) + charToCode(secretWord[keyIndex]) ) % 95)
		
		#Increment the key index to go to the next character in the key
		keyIndex = (keyIndex + 1) % len(secretWord)

	print("PlainText: " + plainText + "\nEncrypted: " + output + "\n")
	return output
	
#Decrypt text character by character	
def decrypt(secretWord, cipherText):
	output = ""
	keyIndex = 0
	for letter in cipherText:

		#Add corresponding key character to decrypted output
		output += codeToChar((charToCode(letter) - charToCode(secretWord[keyIndex]) ) % 95)

		#Increment the key index to go to the next character in the key
		keyIndex = (keyIndex + 1) % len(secretWord)
	
	print("Encrypted: " + cipherText + "\nPlainText: " + output + "\n")
	return output

#Opens the file with plaintext and encrypts it line by line.
#Opens the file with encrypted text and decrypts it line by line.
def main(encryptFile, decryptFile):
	try:
		file = open(encryptFile, 'r')
	except:
		print("Error opening encrypting file.")
		return

	line = file.readline()
	lineNum = 1
	print("Encrypting...")
	while line:
		input = line.split(maxsplit = 1)
		if len(input) < 2:
			print("Error with line number " + lineNum)
		else:
			encrypt(input[0], input[1][:-1])

		line = file.readline()
		lineNum += 1

	try:
		file = open(decryptFile, 'r')
	except:
		print("Error opening decrypting file.")
		return

	line = file.readline()
	lineNum = 1
	print("Decrypting...")
	while line:
		input = line.split(maxsplit = 1)
		if len(input) < 2:
			print("Error with line number " + lineNum)
		else:
			decrypt(input[0], input[1][:-1])

		line = file.readline()
		lineNum += 1

main("encryptor_input.txt", "decryptor_input.txt")