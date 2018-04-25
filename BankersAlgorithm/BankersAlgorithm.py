'''

Implementation of Banker's Algorithm.
Answer to Reddits Daily Programmer Challenge #349

'''

# Uses Bankers Algorithm to determine the order that the 
# processes should be selected based on the need dictionary
# (indicating the remaining resources needed for each process),
# allocation dictionary (containing the types of resources currently
# allocated to a process), and the available string (indicating
# the number of available resources of each type)
def getProcessOrder(allocation, available, need):
	processes = []

	while (len(processes) < len(allocation)):
		toDelete = []
		for process, resource in need.items():
			if int(resource) <= int(available):
				available = str(int(allocation[process]) + int(available))
				processes.append(process)
				toDelete.append(resource)
		
		for k, v in need.copy().items():
			if v in toDelete:
				del need[k]

	return processes

# Retrieves the individual digits of a multi digit number
def getDigitList(string):
	return [int(d) for d in string]

# Creates the need matrix (indicating the remaining resources needed for each process)
def getremainingResourcesPerProcess(allocation, max, available):
	need = {}
	for (m,mv), (a,av) in zip(max.items(), allocation.items()):
		key = ""
		maxes = getDigitList(mv)
		allocs = getDigitList(av)
		for d1, d2 in zip(maxes, allocs):
			key += str(d1 - d2)
		need[m] = key
	return need

# Opens the file, creates the allocation dictionary, max dictionary (defining the
# maximum demand for each process), and the available string, and uses this 
# information to implement Banker's algorithm
def main():
	file =  open("input.txt", "r")
	line = file.readline()

	allocation = {}
	max = {}
	available = ""
	count = 0

	while line:
		input = line.split()
		input[0] = input[0][1:] #remove bracket
		input[-1] = input[-1][0:-1] #remove bracket
		
		if (len(input) == 3): #available resources
			for num in input:
				available += num

		else:
			alloc = ""
			maxResources = ""

			for i in range(3):
				alloc += input[i]
			allocation[count] = alloc

			for k in range(3, 6):
				maxResources += input[k]
			max[count] = maxResources

			count += 1


		line = file.readline()

	need = getremainingResourcesPerProcess(allocation, max, available)
	processList = getProcessOrder(allocation, available, need)

	prnt = ""
	for p in processList[:-1]:
		add = "P" + str(p) + ", "
		prnt += add

	add = "P" + str(processList[-1])
	prnt += add

	print(prnt)


main()