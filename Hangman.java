public class Hangman
{
	public static void main(String[] args)
	{
		Data game = new Data();
		boolean done = false;

		String word = game.getWord("nouns.txt");
		String answer = game.getAnswer(word);
		game.printNoose(game.getWrongs());

		while (!done)
		{
			System.out.println(answer);
			System.out.println("");
			System.out.println("Guess a letter!");
			String guess = game.guessLetter();
			System.out.println("");
			game.checkGuess(guess, word);
			answer = game.changeAnswer(answer, guess, word);
			game.printNoose(game.getWrongs());
			if (game.getWrongs() == 6)
			{
				System.out.println("** " + word + " **\n");
				done = true;
			}
			if (game.win(answer))
			{
				System.out.println("** " + word + " **\n");
				System.out.println("YOU WIN\n");
				done = true;
			}
		}
	}
}