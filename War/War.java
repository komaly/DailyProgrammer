/*
This program implements the card game War. It starts off with 2 decks. The first
belongs to Player 1, the second belongs to Player 2. Each player reveals the card
on the top of their deck (dubbed battle). Whoever has the higher card wins the battle,
takes both cards, and puts them in the bottom of their deck. The process repeats,
until 1 player has all of the cards, and is declared the winner. During a battle,
if both players have the same card, then it is war. Both players place their next three 
cards face down, then a card face-up. The owner of the higher face-up card wins the war 
and adds all the face up and face down cards to the bottom of their deck. If the face-up 
cards are again equal then the war repeats with another set of face-down/up cards, until 
one player's face-up card is higher than their opponent's, or both players run out of cards.
If the cards run out, the game is declared a draw.
*/
import java.util.*;

public class War
{
	private List<Integer> deck1 = new ArrayList<Integer>();
	private List<Integer> deck2 = new ArrayList<Integer>();

	public War(String d1, String d2)
	{
		String[] s = d1.trim().split("\\s+");
		
		for (int i = 0; i < s.length ; i++)
		{
			deck1.add(Integer.parseInt(s[i]));
		}

		s = d2.trim().split("\\s+");

		for (int i = 0; i < s.length ; i++)
		{
			deck2.add(Integer.parseInt(s[i]));
		}	
	}

	/*
	When both cards are the same, this function is called to implement the 
	process for war, until either a winner for the war is declared or the 
	game is declared a tie.
	*/
	public int itsWar(List<Integer> p1cards, List<Integer> p2cards)
	{
		if (deck1.size() == 0 && deck2.size() == 0) //Tie
			return -1;

		if (deck1.size() == 0) //Player 2 wins
			return 2;

		if (deck2.size() == 0) //Player 1 wins
			return 1;

		int size = 0;

		if (deck1.size() >= 4 && deck2.size() >= 4)
		 	size = 4;

		if (deck1.size() < 4)
			size = deck1.size();

		if (deck2.size() < 4)
			size = deck2.size();

		List<Integer> p1WarCards = new ArrayList<Integer>(deck1.subList(0, size));
		List<Integer> p2WarCards = new ArrayList<Integer>(deck2.subList(0, size));

		p1cards.addAll(p1WarCards);
		p2cards.addAll(p2WarCards);

		deck1.removeAll(p1WarCards);
		deck2.removeAll(p2WarCards);

		int p1_Up = p1WarCards.get(size - 1);
		int p2_Up = p2WarCards.get(size - 1);

		if (p1_Up > p2_Up) //Player 1 wins war
		{
			for (int i = p1cards.size() - 1; i >= 0; i-= 4)
			{
				if (i >= 0)
					deck1.add(p1cards.get(i));
				if (i - 1 >= 0)
					deck1.add(p1cards.get(i - 1));
				if (i - 2 >= 0)
					deck1.add(p1cards.get(i - 2));
				if (i - 3 >= 0)
					deck1.add(p1cards.get(i - 3));

				if (i >= 0)
					deck1.add(p2cards.get(i));
				if (i - 1 >= 0)
					deck1.add(p2cards.get(i - 1));
				if (i - 2 >= 0)
					deck1.add(p2cards.get(i - 2));
				if (i - 3 >= 0)
					deck1.add(p2cards.get(i - 3));

			}

			return 1;
		}

		else if (p1_Up < p2_Up) //Player 2 wins war
		{
			for (int i = p2cards.size() - 1; i >= 0; i-= 4)
			{
				if (i >= 0)
					deck2.add(p2cards.get(i));
				if (i - 1 >= 0)
					deck2.add(p2cards.get(i - 1));
				if (i - 2 >= 0)
					deck2.add(p2cards.get(i - 2));
				if (i - 3 >= 0)
					deck2.add(p2cards.get(i - 3));

				if (i >= 0)
					deck2.add(p1cards.get(i));
				if (i - 1 >= 0)
					deck2.add(p1cards.get(i - 1));
				if (i - 2 >= 0)
					deck2.add(p1cards.get(i - 2));
				if (i - 3 >= 0)
					deck2.add(p1cards.get(i - 3));
			}


			return 2;
		}

		else //Tie, so war is redone	
			return itsWar(p1cards, p2cards);
		
	}

	/*
	This function is called while playing the game; it has each player
	show the card at the top of their deck. Whoever has the higher valued
	card wins the battle. If the cards are the same, a war is declared.
	*/
	public int battle()
	{
		int one = deck1.get(0);
		int two = deck2.get(0);

		deck1.remove(0);
		deck2.remove(0);

		if (one > two) //Player 1 won
		{
			deck1.add(one);
			deck1.add(two);

			return 1;
		}

		else if (one < two) //Player 2 won
		{
			deck2.add(two);
			deck2.add(one);

			return 2;
		}

		else //It's a tie so war!
		{
			List<Integer> p1cards = new ArrayList<Integer>();
			List<Integer> p2cards = new ArrayList<Integer>();
	
			int output = itsWar(p1cards, p2cards);
			if (output == -1)
			{
				return -1;
			}

			else if (output == 1) //Player 1 won war
			{
				deck1.add(one);
				deck1.add(two);
			}

			else if (output == 2) //Player 2 won war
			{
				deck2.add(two);
				deck2.add(one);
			}
		}

		
		return 0;
	}

	/*
	This function is called to begin the game and play it until
	a player wins or there is a tie.
	*/
	public void play()
	{
		while(deck1.size() != 0 && deck2.size() != 0)
		{
			if (battle() == -1)
			{
				System.out.println("It's a tie!");
				return;
			}
		}

		if (deck1.size() == 0)
		{
			System.out.println("Player 2 won!");
		}

		else if (deck2.size() == 0) 
		{
			System.out.println("Player 1 won!");
		}
	}

	public static void main(String[] args)
	{
		War w = new War("5 1 13 10 11 3 2 10 4 12 5 11 10 5 7 6 6 11 9 6 3 13 6 1 8 1", "9 12 8 3 11 10 1 4 2 4 7 9 13 8 2 13 7 4 2 8 9 12 3 12 7 5");
		w.play();

		War w1 = new War("3 11 6 12 2 13 5 7 10 3 10 4 12 11 1 13 12 2 1 7 10 6 12 5 8 1", "9 10 7 9 5 2 6 1 11 11 7 9 3 4 8 3 4 8 8 4 6 9 13 2 13 5");
		w1.play();

		War w2 = new War("1 2 3 4 5 6 7 8 9 10 11 12 13 1 2 3 4 5 6 7 8 9 10 11 12 13", "1 2 3 4 5 6 7 8 9 10 11 12 13 1 2 3 4 5 6 7 8 9 10 11 12 13");
		w2.play();
	}
}