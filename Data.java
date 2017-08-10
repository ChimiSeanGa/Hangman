import java.util.*;
import java.io.*;

public class Data
{
	private int wrongs = 0;
	private ArrayList<String> guesses = new ArrayList<String>();

	public int getWrongs()
	{
		return wrongs;
	}

	public String getWord(String filename)
	{
		Scanner readFile = null;

		try
		{
			readFile = new Scanner(new File(filename));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		Random rand = new Random();
		int randNum = rand.nextInt(2328);

		for (int i = 0; i < randNum; i ++)
			readFile.nextLine();

		return readFile.nextLine();
	}

	public String guessLetter()
	{
		Scanner input = new Scanner(System.in);
		String in = input.next();
		while (in.length() > 1 || guesses.contains(in.substring(0, 1)))
		{
			if (in.length() > 1)
				System.out.println("Not a valid letter! Try again.");
			else if (guesses.contains(in.substring(0, 1)))
				System.out.println("You already guessed that letter! Try again.");
			in = input.next();
		}
		guesses.add(in.substring(0, 1));
		return in.substring(0, 1);
	}

	public void checkGuess(String guess, String word)
	{
		if (word.contains(guess))
		{
			System.out.println("Yes! The word does contain a(n) '" + guess + "'!");
		}
		else
		{
			System.out.println("Nope, there is no '" + guess + "' in the word. You're one step closer to the noose.");
			wrongs ++;
		}
	}

	public void printNoose(int wrongs)
	{
		if (wrongs < 1)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 1)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 2)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|     |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 3)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|    /|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 4)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|    /|\\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 5)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|    /|\\");
			System.out.println("|    /");
			System.out.println("|");
			System.out.println("|");
			System.out.println("-------------");
		}
		else if (wrongs == 6)
		{
			System.out.println("-------");
			System.out.println("|     |");
			System.out.println("|     o");
			System.out.println("|    /|\\");
			System.out.println("|    / \\");
			System.out.println("|");
			System.out.println("| GAME OVER");
			System.out.println("-------------");
		}
	}

	public String getAnswer(String word)
	{
		String ans = "";

		for (int i = 0; i < word.length(); i ++)
		{
			if (word.substring(i, i + 1).equals("-"))
				ans += "- ";
			else if (word.substring(i, i + 1).equals(" "))
				ans += "  ";
			else
				ans += "_ ";
		}

		return ans;
	}

	public String changeAnswer(String ans, String letter, String word)
	{
		for (int i = 0; i < word.length(); i ++)
			if (word.substring(i, i + 1).equals(letter))
			{
				StringBuilder editAns = new StringBuilder(ans);
				editAns.replace(i * 2, (i * 2) + 1, letter);
				ans = editAns.toString();
			}

		return ans;
	}

	public boolean win(String ans)
	{
		boolean noSpace = true;
		for (int i = 0; i < ans.length(); i ++)
			if (ans.substring(i, i + 1).equals("_"))
				noSpace = false;

		return noSpace;
	}
}

