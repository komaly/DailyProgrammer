/*
Calculator that can do addition, subtraction, multiplication, division,
and exponents of 2 numbers. All expressions calculated using only addition.
*/

import java.util.*;
import java.lang.*;


public class AddingCalculator
{
	int num1;
	int num2;
	char c;

	AddingCalculator(){}

	/*
	Adds two numbers
	*/
	public void addition()
	{
		int solution = num1 + num2;
		System.out.println("Solution: " + solution);
		getUserInput();
	}

	/*
	Subtracts two numbers
	*/
	public void subtraction()
	{	
		num2 = -num2;
		int solution = num1 + num2;
		System.out.println("Solution: " + solution);
		getUserInput();
	}

	/*
	Helper function to multiply two numbers
	*/
	private int mult(int n1, int n2)
	{
		int count = 0;
		for (int i = 0; i < Math.abs(n2); i++)
			count += Math.abs(n1);

		if (n1 < 0 && n2 < 0)
			return count;

		if (n1 < 0 || n2 < 0)
			count = -count;

		
		return count;
	}

	/*
	Multiplies two numbers
	*/
	public void multiplication()
	{
		System.out.println("Solution: " + mult(num1, num2));
		getUserInput();
	}

	/*
	Divides two numbers
	*/
	public void division()
	{
		if (num1 == 0 && num2 == 0)
		{
			System.out.println("Solution: Undefined");
			getUserInput();
		}

		int n2 = -(Math.abs(num2));
		int n1 = Math.abs(num1);
		int count = 0;
		while(n1 > 0)
		{
			count += 1;
			n1 = n1 + n2;
		}

		if (n1 != 0)
		{
			System.out.println("Solution: Non integral answer.");
			getUserInput();
		}

		if (num1 < 0 && num2 < 0)
		{
			System.out.println("Solution: " + count);
			getUserInput();
		}

		if (num1 < 0 || num2 < 0)
			count = -count;

		System.out.println("Solution: " + count);
		getUserInput();

	}

	/*
	Solves exponents.
	*/
	public void exponents()
	{
		if (num2 < 0)
		{
			System.out.println("Solution: Non integral answer");
			getUserInput();
		}

		int count = 1;
		for (int i = 0; i < num2; i++)
			count = mult(count, num1);
		
		System.out.println("Solution: " + count);
		getUserInput();

	}

	/*
	Retrieves user input
	*/
	public void getUserInput()
	{
		Scanner reader = new Scanner(System.in);  
		System.out.print("Enter an equation: ");
		num1 = reader.nextInt();
		c = reader.next().charAt(0);
		num2 = reader.nextInt();

		if (c == '+')
			addition();
		else if (c == '-')
			subtraction();
		else if (c == '*')
			multiplication();
		else if (c == '/')
			division();
		else if (c == '^')
			exponents();
	}


	public static void main(String[] arguments)
	{
		AddingCalculator a = new AddingCalculator();
		a.getUserInput();

	}
}