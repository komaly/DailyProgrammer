/*
This program uses a transposition route cipher to encrypt and decrypt text. Given the dimensions
of a grid, the text is displayed in the grid, and starting from the top right
corner of the grid, the grid either spirals in a clockwise direction or a counter
clockwise dimension, depending on the given instructions. The order of the spiral is the
newly encrypted text. The reverse is done to decrypt the text.
*/


import java.util.*;

public class TranspositionCipher
{
	public String text;
	int columns;
	int rows;
	String direction;

	TranspositionCipher(String t, int c, int r, String d)
	{
		text = t.replaceAll("[^a-zA-Z]", "");
		columns = c;
		rows = r;
		direction = d;

	}

	/*
	Encrypts the text by spiraling counter clockwise.
	*/
	public ArrayList<Character> counterClockwiseEncryption(char[][] grid)
	{
		int r = rows;
		int c = columns;

		int x = 0;
		int y = columns - 1;

		ArrayList<Character> result = new ArrayList<Character>();

		while(r > 0 && c > 0)
		{
            if (r == 1)
            {
                for (int i=0; i < c; i++)
                {
                    result.add(grid[x][y]);
                    y--;
                }
                break;
            }
            else if (c == 1)
            {
                for (int i=0; i < r; i++)
                {
                    result.add(grid[x][y]);
                    x++;
                }
                break;
            }

            //move left
            for (int i = 0; i < c-1; i++)
            {
            	result.add(grid[x][y]);
            	y--;
            }


            //move down
            for (int i = 0; i < r-1; i++)
            {
            	result.add(grid[x][y]);
            	x++;
            }

             //move right
            for (int i = 0; i < c-1; i++)
            {
            	result.add(grid[x][y]);
            	y++;
            }

           
            //move up
            for (int i = 0; i < r-1; i++)
            {
            	result.add(grid[x][y]);
            	x--;
            }

           

            x++;
            y--;
            r = r-2;
            c = c-2;
        }

        return result;
	}

	/*
	Encrypts the text by spiraling clockwise.
	*/
	public ArrayList<Character> clockwiseEncryption(char[][] grid)
	{
		int r = rows;
		int c = columns;

		int x = 0;
		int y = columns - 1;

		ArrayList<Character> result = new ArrayList<Character>();

		while(r > 0 && c > 0)
		{
            if (r == 1)
            {
                for (int i=0; i < c; i++)
                {
                    result.add(grid[x][y]);
                    y--;
                }
                break;
            }
            else if (c == 1)
            {
                for (int i=0; i < r; i++)
                {
                    result.add(grid[x][y]);
                    x++;
                }
                break;
            }
 
            //move down
            for (int i = 0; i < r-1; i++)
            {
            	result.add(grid[x][y]);
            	x++;
            }

            //move left
            for (int i = 0; i < c-1; i++)
            {
            	result.add(grid[x][y]);
            	y--;
            }

            //move up
            for (int i = 0; i < r-1; i++)
            {
            	result.add(grid[x][y]);
            	x--;
            }

            //move right
            for (int i = 0; i < c-1; i++)
            {
            	result.add(grid[x][y]);
            	y++;
            }

            x++;
            y--;
            r = r-2;
            c = c-2;
        }

        return result;
	}

	/*
	Creates the grid of the text given the grid dimensions.
	*/
	public char[][] createGrid()
	{
		char[][] grid = new char[rows][columns];
		int len = 0;
		
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[i].length; j++)
			{
				if (len >= text.length())
				{
					grid[i][j] = 'X';
					continue;
				}
				 
		  		grid[i][j] = Character.toUpperCase(text.charAt(len));
		  		len++;
			}

		}

		return grid;
	}

	/*
	Creates the text grid and encrypts the text depending on the spiral direction.
	*/
	public ArrayList<Character> encryptText()
	{
		char[][] grid = createGrid();
		ArrayList<Character> result = new ArrayList<Character>();

		if (direction.equals("clockwise"))
		{
			result = clockwiseEncryption(grid);
		}
		else if (direction.equals("counter-clockwise"))
		{
			result = counterClockwiseEncryption(grid);
		}

		printText(result);
		return result;
	}

	/*
	Decrypts the text by spiraling counter clockwise.
	*/
	public char[][] counterClockwiseDecryption(ArrayList<Character> encryptedText)
	{
		char[][] grid = new char[rows][columns];

		int r = rows;
		int c = columns;

		int x = 0;
		int y = columns - 1;

		int index = 0;

		while(r > 0 && c > 0)
		{
            if (r == 1)
            {
                for (int i=0; i < c; i++)
                {
                	grid[x][y] = encryptedText.get(index);
            		index++;
                    y--;
                }
                break;
            }
            else if (c == 1)
            {
                for (int i=0; i < r; i++)
                {
                	grid[x][y] = encryptedText.get(index);
            		index++;
                    x++;
                }
                break;
            }
 
             //move left
            for (int i = 0; i < c-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	y--;
            }

            //move down
            for (int i = 0; i < r-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	x++;
            }

             //move right
            for (int i = 0; i < c-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	y++;
            }

            //move up
            for (int i = 0; i < r-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	x--;
            }

            x++;
            y--;
            r = r-2;
            c = c-2;
        }

        return grid;
	}

	/*
	Decrypts the text by spiraling clockwise.
	*/
	public char[][] clockwiseDecryption(ArrayList<Character> encryptedText)
	{

		char[][] grid = new char[rows][columns];

		int r = rows;
		int c = columns;

		int x = 0;
		int y = columns - 1;

		int index = 0;

		while(r > 0 && c > 0)
		{
            if (r == 1)
            {
                for (int i=0; i < c; i++)
                {
                	grid[x][y] = encryptedText.get(index);
            		index++;
                    y--;
                }
                break;
            }
            else if (c == 1)
            {
                for (int i=0; i < r; i++)
                {
                	grid[x][y] = encryptedText.get(index);
            		index++;
                    x++;
                }
                break;
            }
 
            //move down
            for (int i = 0; i < r-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	x++;
            }

            //move left
            for (int i = 0; i < c-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	y--;
            }

            //move up
            for (int i = 0; i < r-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	x--;
            }

            //move right
            for (int i = 0; i < c-1; i++)
            {
            	grid[x][y] = encryptedText.get(index);
            	index++;
            	y++;
            }

            x++;
            y--;
            r = r-2;
            c = c-2;
        }

        return grid;
	}

	/*
	Creates an empty grid, fills it with the encrypted text 
	based on the spiral direction, and prints the grid to 
	decrypt the text.
	*/
	public void decryptText(ArrayList<Character> encryptedText)
	{
		char grid[][] = new char[rows][columns];

		if (direction.equals("clockwise"))
		{
			grid = clockwiseDecryption(encryptedText);

		}
		else if (direction.equals("counter-clockwise"))
		{
			grid = counterClockwiseDecryption(encryptedText);
		}

		printDecryptedText(grid);
	}

	/*
	Prints the decrypted text.
	*/
	public void printDecryptedText(char[][] grid)
	{
		System.out.print("Decrypted Text: ");

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				System.out.print(grid[i][j]);
			}
		}
		System.out.println("\n");
	}

	/*
	Prints the encrypted text.
	*/
	public void printText(ArrayList<Character> encryptedText)
	{
		System.out.print("Encrypted Text: ");

		 for (int i = 0; i < encryptedText.size(); i++)
		 {
		 	System.out.print(encryptedText.get(i));
		 }
		 System.out.println();
	}

	public static void main(String[] arguments)
	{
		System.out.println("Clockwise encryption/decryption: ");

		TranspositionCipher t = new TranspositionCipher("WE ARE DISCOVERED. FLEE AT ONCE", 9, 3, "clockwise");
		System.out.println("Original Text: WE ARE DISCOVERED. FLEE AT ONCE");
		ArrayList<Character> encryptedText = t.encryptText();
		t.decryptText(encryptedText);

		TranspositionCipher t3 = new TranspositionCipher("For lunch let's have peanut-butter and bologna sandwiches", 4, 12, "clockwise");
		System.out.println("Original Text: For lunch let's have peanut-butter and bologna sandwiches");
		ArrayList<Character> encryptedText3 = t3.encryptText();
		t3.decryptText(encryptedText3);

		TranspositionCipher t4 = new TranspositionCipher("I've even witnessed a deer in the road.", 9, 5, "clockwise");
		System.out.println("Original Text: I've even witnessed a deer in the road.");
		ArrayList<Character> encryptedText4 = t4.encryptText();
		t4.decryptText(encryptedText4);

		System.out.println("Counter-clockwise encryption/decryption: ");

		TranspositionCipher t6 = new TranspositionCipher("Solving challenges on r/dailyprogrammer is so much fun!!", 8, 6, "counter-clockwise");
		System.out.println("Original Text: Solving challenges on r/dailyprogrammer is so much fun!!");
		ArrayList<Character> encryptedText6 = t6.encryptText();
		t6.decryptText(encryptedText6);

		TranspositionCipher t7 = new TranspositionCipher("Why does it say paper jam when there is no paper jam?", 3, 14, "counter-clockwise");
		System.out.println("Original Text: Why does it say paper jam when there is no paper jam?");
		ArrayList<Character> encryptedText7 = t7.encryptText();
		t7.decryptText(encryptedText7);
	}
}