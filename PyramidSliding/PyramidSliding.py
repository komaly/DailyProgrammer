'''
Given a pyramid, find the smallest way down the pyramid,
if you can only slide directly downwards or down and directly
to the right of the given number. The output is the sum
of the shortest path.
'''

#Calculates the sum of the shortest path
def calculatePathTotal(path):
	count = 0
	for num in path:
		count += int(num)
	return count

#Traverses through the pyramid to find the shortest path
def traversePyramid(size, pyramid):
	path = [pyramid[0][0]]
	j = 0
	for i in range(size - 1): #0, 1, 2
		child1 = int(pyramid[i+1][j])
		child2 = int(pyramid[i+1][j+1])
		if child1 < child2:
			path.append(child1)
			
		if child1 > child2:
			path.append(child2)
			j += 1

	return path

#Loads pyramid and height of pyramid from file
def loadFromFile(fileName):
	with open(fileName) as f:
		size = f.readline()
		return (size, [[num for num in line.split()] for line in f])


def main(fileName, fnum):
	print("Output for input" + str(fnum) + ".txt:")
	size, pyramid = loadFromFile(fileName)
	path = traversePyramid(int(size), pyramid)
	print(calculatePathTotal(path))

main("input1.txt", 1)
main("input2.txt", 2)
main("input3.txt", 3)
main("input4.txt", 4)