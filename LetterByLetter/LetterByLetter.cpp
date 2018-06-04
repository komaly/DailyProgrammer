using namespace std;
#include "LetterByLetter.h"
#include <iostream>
#include <vector>
#include <fstream>
#include <algorithm>

//Takes the original word/sentence and the word/sentence
//that is the end result, and changes the original word/sentence
//into the resulting word/sentence letter by letter 
void LetterByLetter::printNewWordLetterByLetter(string original, string result)
{
		vector<string> check;

		for (int i = 0; i < original.size(); i++)
		{
			string toPrint = result.substr(0, i) + original.substr(i, original.size());
	
			if(find(check.begin(), check.end(), toPrint) == check.end()) 
			{
				cout << toPrint << endl;
				check.push_back(toPrint);
			}
		}

		cout << endl;
}

//Takes in a file name, reads the file specified line by line,
//and puts the contents of each line into a vector of strings
vector<string> LetterByLetter::getInputLines(string file)
{
	vector<string> input;
	string line;

	ifstream infile(file);

	while(getline(infile, line))
	{
		input.push_back(line);
	}

	return input;
}

