'''
Given 2 numbers, the first number n specifying the number of stacks and the
second number being a string of numbers, each one a box, this program
emits n stacks of boxes, with each stack having the same total size.
'''
from itertools import combinations

#Creates stacks of boxes with all stacks having the same total size
def createStacks(numOfStacks, boxes):
    allBoxes = [int(b) for b in boxes]
    sizePerStack = sum(allBoxes) / numOfStacks

    r1 = len(allBoxes) // numOfStacks

    allPossibleCombinations = [combinations(allBoxes, i) for i in range(r1, r1 + 2)]

    condensedCombinations = []
    for item in allPossibleCombinations:
        for combo in item:
            x = sorted(combo, reverse = True)
            if x not in condensedCombinations:
                condensedCombinations.append(x)

    output = []
    for combo in sorted(condensedCombinations, key = lambda x: len(x), reverse = True):
        if sum(combo) == sizePerStack :
            output.append(combo)
            
    for sets in combinations(output, numOfStacks):
        if checkValidity(sets, boxes):
            return sets

    return []
    
#Checks if the given stacks are a valid solution
def checkValidity(sets, boxes):
    AllBoxes = [int(b) for b in boxes]
    out = []
    for stack in sets:
        for num in stack:
            out.append(num)

    return sorted(AllBoxes) == sorted(out)

#Loads the file with information on each stack size and its correlated boxes
def loadFileInformation(fileName):
    l = []
    with open(fileName) as f:
        for line in f:
            numOfStacks, boxes = line.split()
            l.append((numOfStacks, boxes))
    return l

def main():
    l = loadFileInformation("input.txt")
    for numOfStacks, boxes in l:
        print("Results for making " + numOfStacks + " stacks with the boxes " + boxes)
        output = createStacks(int(numOfStacks), boxes)

        if (len(output) < int(numOfStacks)):
            print("No possible stacks.")
            print()
            continue

        print("Stack: ")
        for stack in output:
            for box in stack:
                print(box, end = " ")
            
            print()
        print()
         
main()