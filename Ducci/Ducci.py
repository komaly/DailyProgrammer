'''
Calculates the Ducci sequence of a tuple until the pattern
starts repeating itself or until the pattern is a sequence of 
zero's.
'''


'''Calculates the next tuple in the Ducci sequence'''
def calculateTuple(tup):
	output = []
	for i in range(len(tup)):
		if i == len(tup) - 1:
			num = abs(tup[i] - tup[0])
			output.append(num)
		else:
			num = abs(tup[i+1] - tup[i])
			output.append(num)
	return output

'''Prints the tuple in the Ducci sequence'''
def printTuple(tup):
	print(' '.join(str(x) for x in tup))

'''Calculates tuples for the Ducci sequence until
all elements in a sequence are 0 or until the pattern
starts repeating itself'''
def run(tup):
	printTuple(tup)
	count = 1
	check = [tup]

	while not all(i == 0 for i in tup):
		out = calculateTuple(tup)
		if out in check:
			print("Repeating pattern: " + str(' '.join(str(x) for x in out)))
			break
		else:
			check.append(out)
			printTuple(out)
			count+=1
			tup = out

	print(str(count) + " steps")

'''Calculates the Ducci sequence for each tuple'''
def main(tup):
	print("Input: " + str(' '.join(str(x) for x in tup)))
	print("\n")
	print("Output: ")
	run(tup)
	print("\n")


main((0, 653, 1854, 4063))
main((1, 5, 7, 9, 9))
main((1, 2, 1, 2, 1, 0))
main((10, 12, 41, 62, 31, 50))
main((10, 12, 41, 62, 31))