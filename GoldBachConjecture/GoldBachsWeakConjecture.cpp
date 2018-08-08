/*
This program takes an odd number and yields 3 prime numbers
that sum up to the odd number, implementing Goldbach's weak 
conjecture. The conjecture states that every odd number greater
than 5 can be expressed as the sum of 3 prime numbers.
*/
#include <iostream>
#include <fstream>
#include <limits>
#include <cmath>
#include <vector>
using namespace std;

/*
Checks if a number is prime.
*/
bool isPrime(int n)
{
	if (n < 2)
	 	return false;

	 if (n == 2)
	 	return true;

	 if (n % 2 == 0)
	 	return false;
 
    for (int i = 3; i <= sqrt(n); i+=2)
        if (n % i == 0)
            return false;
 
    return true;
}

/*
Finds 3 prime numbers that sum up to the 
given number.
*/
vector<int> findPrimes(int n)
{
	vector<int> l;
	vector<int> output;

	if (n % 2 == 0 || n < 5)
		return output;

	for (int i = 2; i < n; i++)
	{
		if (isPrime(i))
			l.push_back(i);
	}
	
	for (int j = 0; j < l.size(); j++)
	{
		for (int k = 0; k < l.size(); k++)
		{
			for (int m = 0; m < l.size(); m++)
			{
				if (l[j] + l[k] + l[m] == n)
				{
					output.push_back(l[j]);
					output.push_back(l[k]);
					output.push_back(l[m]);
					return output;
				}
			}
		}
	}

	return output;	
}

/*
Prints out the given number and the 3 prime numbers
that add up to it.
*/
void printOutput(vector<int> output, int n)
{
	if (output.size() == 0)
	{
		cout << "Error with " << n << ". Number must be odd number greater than 5." << endl;
		return;
	}

	cout << n << " = ";
	for (int i = 0; i < output.size(); i++)
	{
		if (i == output.size() - 1)
			cout << output[i] << endl;
		else
	    	cout << output[i] << " + ";
	}
}


int main(int argc, char const *argv[])
{
	//saveAllPrimes();

	vector<int> output = findPrimes(11);
	printOutput(output, 11);
	
	vector<int> output1 = findPrimes(35);
	printOutput(output1, 35);
	
	vector<int> output2 = findPrimes(111);
	printOutput(output2, 111);
	
	vector<int> output3 = findPrimes(17);
	printOutput(output3, 17);
	
	vector<int> output4 = findPrimes(199);
	printOutput(output4, 199);
	
	vector<int> output5 = findPrimes(287);
	printOutput(output5, 287);
	
	vector<int> output6 = findPrimes(53);
	printOutput(output6, 53);
	return 0;
}