/*
This program takes in two matrices showing the sales figure per salesperson for each product they sold, 
and the expenses by product per salesperson. It then calculates the commission for each salesperson for 
the month, which is 6.2% of their total profit.
*/

import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.text.DecimalFormat;

public class SalesCommissions
{
	SalesCommissions(){}

	/*Initializes map with the salespeoples names as key and empty lists as values*/
	public void initializeMapWithKeys(LinkedHashMap<String, ArrayList<Integer>> profit, String fName)
	{
		try
		{
			String line = Files.readAllLines(Paths.get(fName)).get(2);
			String[] names = line.trim().split("\\s+");

			for (int i = 0; i < names.length; i++)
			{
				ArrayList<Integer> value = new ArrayList<Integer>();
				profit.put(names[i], value);
			}	
		}
		
		catch(Exception e)
		{
			System.out.println("Error when initializing map.");
		}
		
	}

	/*Skips lines with no useful information*/
	public void skipLine(Scanner input)
	{
		for (int i = 0; i < 3; i++)
		{
			input.nextLine();
		}
	}

	/*Adds revenues for each item for each salesperson to the map*/
	public void addRevenue(Scanner input, LinkedHashMap<String, ArrayList<Integer>> profit)
	{
		while (input.hasNext())
		{
			String l = input.nextLine();
			if (!l.equals(""))
			{	
				String[] vals = l.trim().split("\\s+");
				int count = 1;

				for (Map.Entry<String, ArrayList<Integer>> entry : profit.entrySet()) 
				{
					ArrayList<Integer> value = entry.getValue();
					value.add(Integer.parseInt(vals[count]));
					count++;
				}
			}
			else
				break;
		}
	}

	/*Subtracts expenses from revenues for each item for each salesperson in the map*/
	public void subtractExpenses(Scanner input, LinkedHashMap<String, ArrayList<Integer>> profit)
	{
		int count2 = 0;
		while (input.hasNext())
		{
			String l = input.nextLine();
			if (!l.equals(""))
			{
				String[] vals = l.trim().split("\\s+");
				int count = 1;

				for (Map.Entry<String, ArrayList<Integer>> entry : profit.entrySet())
				{
					ArrayList<Integer> value = entry.getValue();
					int num = value.get(count2) - Integer.parseInt(vals[count]);
					if (num < 0)
						num = 0;

					value.set(count2, num);
					count++;
				}

				count2++;
			}
			
			else
				break;
		}
	}

	/*Caluculates total profit for each salesperson and calculates the commission, which is 6.2% of the profit.*/
	public LinkedHashMap<String, Double> calculateCommission(LinkedHashMap<String, ArrayList<Integer>> profit)
	{
		LinkedHashMap<String, Double> finalR = new LinkedHashMap<String, Double>();
		for (Map.Entry<String, ArrayList<Integer>> entry : profit.entrySet())
		{
			ArrayList<Integer> value = entry.getValue();
			double add = 0;

			for (int i = 0; i < value.size(); i++)
			{
				add += value.get(i);
			}

			double commission = add * .062;

			DecimalFormat df = new DecimalFormat("#.##");      
			commission = Double.valueOf(df.format(commission));

			finalR.put(entry.getKey(), commission);
		}

		return finalR;
	}

	/*Prints the map showing each salesperson and the commission they earned*/
	public void printResults(LinkedHashMap<String, Double> finalR)
	{
			System.out.print("                ");
			for (Map.Entry<String, Double> entry : finalR.entrySet())
			{
				System.out.print(entry.getKey() + " ");
			}

			System.out.println();
			System.out.print("Commission      ");

			for (Map.Entry<String, Double> entry : finalR.entrySet())
			{
				System.out.print(entry.getValue() + "   ");
			}
	}

	/*Runs all functions to calculate commission for each salesperson*/
	public void calculateFromFile(String fName)
	{
		try
		{
			LinkedHashMap<String, ArrayList<Integer>> profit = new LinkedHashMap<String, ArrayList<Integer>>();

			initializeMapWithKeys(profit, fName);

			Scanner input = new Scanner (new File(fName));
			
			skipLine(input);

			addRevenue(input, profit);

			skipLine(input);
			
			subtractExpenses(input, profit);

			LinkedHashMap<String, Double> finalR = calculateCommission(profit);

			printResults(finalR);
		}
		
		catch(Exception e)
		{
			System.out.println("Error");
		}			

	}

	public static void main(String[] args)
	{
		SalesCommissions s = new SalesCommissions();
		s.calculateFromFile("input1.txt");

		System.out.println("\n");

		SalesCommissions s2 = new SalesCommissions();
		s2.calculateFromFile("input2.txt");
	}
}