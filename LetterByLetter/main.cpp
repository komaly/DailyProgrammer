/*
	Retrieves the words/sentences from the file and for every 2 
	words/sentences it transforms the first word/sentence into
	the second word/sentence letter by letter.
*/

#include "LetterByLetter.h"
#include <vector>

int main()
{
	LetterByLetter lByl;
	vector<string> input = lByl.getInputLines("input.txt");
	for (int j = 0; j < input.size(); j+=2)
	{
		lByl.printNewWordLetterByLetter(input[j], input[j+1]);
	}
}