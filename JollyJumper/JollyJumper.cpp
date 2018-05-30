/*The jollyJumper function checks if the sequence of numbers is jolly. 
It checks if the absolute values of the differences between successive 
elements take  on all possible values through n - 1 (which may include 
negative numbers).*/

using namespace std;
#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <sstream>
#include <cmath>
#include <set>

//Checks if the given sequence of numbers, excluding the first number 
//(which specifies the number of elements in the sequence) is jolly
//or not.
void jollyJumper(string str)
{
	vector<int> array;
	stringstream ss(str);
	int temp;
	while (ss >> temp)
	    array.push_back(temp); 

	set<int> values;
	set<int> allPossibleValues;
	for (int i = 1; i < array[0]; i++)
		values.insert(abs(array[i] - array[i + 1]));

	for (int j = 1; j < array[0]; j++)
		allPossibleValues.insert(j);

	if (allPossibleValues == values)
		cout << "The sequence of numbers \"" << str << "\" excluding the first number is JOLLY" << endl;
	else
		cout << "The sequence of numbers \"" << str << "\" excluding the first number is NOT JOLLY " << endl;

}

//Uses the jollyJumper function on a series
//of strings.
int main(int argc, char const *argv[])
{
	string str = "4 1 4 2 3";
	string str2 = "5 1 4 2 -1 6";
	string str3 = "4 19 22 24 21";
	string str4 = "4 19 22 24 25";
	string str5 = "4 2 -1 0 2";
	
	jollyJumper(str);
	jollyJumper(str2);
	jollyJumper(str3);
	jollyJumper(str4);
	jollyJumper(str5);

	return 0;
}