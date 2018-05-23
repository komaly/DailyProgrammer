/*
	The class LetterByLetter takes in an input file with a word or sentence on each line.
	For every 2 words/sentences, the class transforms the first word/sentence into 
	the second word/sentence letter by letter.

	Ex) input: bay, mop
		output: bay
				may
				moy
				mop
*/

#include <string>
#include <vector>
using namespace std;

#ifndef LETTERBYLETTER
#define LETTERBYLETTER

class LetterByLetter
{
	public:

		LetterByLetter(){}

		void printNewWordLetterByLetter(string original, string result);
		vector<string> getInputLines(string file);

};

#endif