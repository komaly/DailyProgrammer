#include "computeDayOfTheWeek.h"
#include <fstream>
#include <iostream>
using namespace std;

/* Opens the input file and reads it line by line, computing the day
   of the week for each line.
*/
int main()
{
	ifstream infile("input.txt");
	int y, m, d;
	int line = 0;
	while (infile >> y >> m >> d)
	{
		line++;
		if (y > 0 && y < 8000 && m > 0 && m < 13 && d > 0 && d < 32)
		{
			computeDayOfTheWeek c(y, m, d);
			cout << "Date: " << m << "/" << d << "/" << y << " Day: " << c.calculateDay() << endl;
		}

		else
		{
			cout << "Error with input at line number " << line << ", skipping this line." << endl;
		}
	}
	    
	return 0;
}