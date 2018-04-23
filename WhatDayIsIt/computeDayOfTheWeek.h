/*

Given the year, month, and date, compute the day of the week.
Answer to Reddits Daily Programmer Challenge #338

*/

#include <string>
using namespace std;

#ifndef COMPUTEDAY
#define COMPUTEDAY

class computeDayOfTheWeek
{
	public:
		int month, day, year;
		int months [12] = {11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		string days[7] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

		computeDayOfTheWeek(){}

		computeDayOfTheWeek(int y, int m, int d)
		{
			year = y;
			month = m;
			day = d;
		}

		string calculateDay();
};

#endif