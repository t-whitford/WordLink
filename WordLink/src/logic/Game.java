package logic;

/**
 * Class to create and potentially control the game state
 * @author Tom
 *
 */
public class Game {
	
	Word[] words;
	Grid grid;
	
	/**
	 * Creates a new Game state with random words and grid
	 */
	public Game()
	{
		words = Word.buildList();
		grid = new Grid();
	}

	/**
	 * 
	 * @return The list of words
	 */
	public Word[] getWords() {
		return words;
	}

	/**
	 * 
	 * @return The grid of colours
	 */
	public Grid getGrid() {
		return grid;
	}
	
}
