
/**
* Takes an input A and computes factor pairs B and C such that A = B * C. 
* Computes the smallest B + C value.
* Answer to Reddit's Daily Programmer Challenge #354
*/

public class FindSmallestAdditionOfFactors
{
	private Long num;

	public FindSmallestAdditionOfFactors(Long num)
	{
		this.num = num;
	}

	/**
	* Computes the factor pairs of the given number and 
	* determines the factor pair with the smallest value when the 2 
	* numbers in the pair are added together.
	*/
	public void computeSmallestNumber()
	{
		long min = Integer.MAX_VALUE; 
		for ( long B = 1; B < java.lang.Math.sqrt(num); B++)
		{
			if (num % B == 0)
			{
				long C = num / B;
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
		FindSmallestAdditionOfFactors f1 = new FindSmallestAdditionOfFactors(Long.valueOf(12));
		f1.computeSmallestNumber();

		FindSmallestAdditionOfFactors f2 = new FindSmallestAdditionOfFactors(Long.valueOf(456));
		f2.computeSmallestNumber();

		FindSmallestAdditionOfFactors f3 = new FindSmallestAdditionOfFactors(Long.valueOf(4567));
		f3.computeSmallestNumber();

		FindSmallestAdditionOfFactors f4 = new FindSmallestAdditionOfFactors(Long.valueOf(12345));
		f4.computeSmallestNumber();

		FindSmallestAdditionOfFactors f5 = new FindSmallestAdditionOfFactors(Long.valueOf(1234567891011L));
		f5.computeSmallestNumber();
	}
}