/*

Given the year, month, and date, compute the day of the week.
Answer to Reddits Daily Programmer Challenge #338

*/

#include "computeDayOfTheWeek.h"
#include <math.h>
#include <iostream>
using namespace std;


/* Calculates the day of the week by implementing Zellers rule.
   f = k + [(13*m - 1)/5] + d + [d/4] + [c/4] - 2*c
   f % 7 = # in [1 - 7], each number signifying a day of the week
*/
string computeDayOfTheWeek::calculateDay()
{
	int k = day; //day of the month
	int m = months[month - 1] ; //month number

	if (month < 3) //If the month is January or February, use the previous year
		year = year - 1;

	int d = year % 100; //last two digits of year

	int c = year / 100; //first two digits of year

	int result = (int)((k + floor(((13 * m) - 1) / 5) + d + floor(d / 4) + floor(c / 4) - (2 * c)));

	if (result < 0)
		return days[((result % 7) + 7) % 7];

	return days[result % 7]; 

}