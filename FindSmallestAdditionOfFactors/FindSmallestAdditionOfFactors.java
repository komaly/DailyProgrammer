
/**
* Takes an input A and computes B and C values such that A = B * C. 
* Computes the smallest B + C value.
* Answer to Reddit's Daily Programmer Challenge #354
*/

public class FindSmallestAdditionOfFactors
{
	private int num;

	public FindSmallestAdditionOfFactors(int num)
	{
		this.num = num;
	}

	/**
	* Checks if the given number is divisible by a number (B) in the 
	* range 1 to the square root of the given number. If it is,
	* B is calculated, and if B + C is less than the current minimum
	* then the minimum is updated to B + C.
	*/
	public void computeSmallestNumber()
	{
		int min = Integer.MAX_VALUE; 
		for ( int B = 1; B < java.lang.Math.sqrt(num); B++)
		{
			if (num % B == 0)
			{
				int C = num / B;
				if (B + C < min)
					min = B + C;
			}
		}

		System.out.println("Input: " + num + "\nOutput: " + min + "\n");
	} 

	/**
	* Creates multiple class objects for different inputs and 
	* computes the smallest B + C value for each input.
	*/
	public static void main(String args[])
	{
		FindSmallestAdditionOfFactors f1 = new FindSmallestAdditionOfFactors(12);
		f1.computeSmallestNumber();

		FindSmallestAdditionOfFactors f2 = new FindSmallestAdditionOfFactors(456);
		f2.computeSmallestNumber();

		FindSmallestAdditionOfFactors f3 = new FindSmallestAdditionOfFactors(4567);
		f3.computeSmallestNumber();

		FindSmallestAdditionOfFactors f4 = new FindSmallestAdditionOfFactors(12345);
		f4.computeSmallestNumber();
	}
}