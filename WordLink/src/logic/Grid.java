package logic;

import java.util.Random;

public class Grid {
	
	private Colour[] colours;
	private Colour firstGo;

	/**
	 * Creates a new grid with a random starter and randomly placed colours
	 */
	public Grid()
	{
		colours = new Colour[25];
		
		Random rand = new Random();
		boolean redStart = rand.nextBoolean();
		
		int numRed = 7;
		int numBlue = 7;
		int numGrey = 10;
		
		if(redStart){
			numRed++;
			firstGo = Colour.RED;
		}
		else{
			numBlue++;
			firstGo = Colour.BLUE;
		}
		
		fillGridWithColour(numRed, Colour.RED);
		fillGridWithColour(numBlue, Colour.BLUE);
		fillEmptySpaces();
		
	}
	
	private void fillGridWithColour(int number, Colour colour)
	{
		Random random = new Random();
		
		for(int i = 0; i < number; i++)
		{
			int rand;
			do{
				rand = random.nextInt(25);
			}while(colours[rand] != null);
			
			colours[rand] = colour;
		}
	}
	
	private void fillEmptySpaces()
	{
		for(int i = 0; i < colours.length; i++)
			if(colours[i] == null)
				colours[i] = Colour.GREY;
	}
	
	/**
	 * Returns the colour in a particular position
	 * @param gridPos The position to check
	 * @return the colour in the position
	 */
	public Colour getColour(int gridPos)
	{
		return colours[gridPos];
	}
	
	/**
	 * 
	 * @return An array of all the colours in the grid
	 */
	public Colour[] getAllColours()
	{
		return colours;
	}
	
	/**
	 * 
	 * @return The colour who goes first (and has 8 words to find)
	 */
	public Colour getFirstGoColour()
	{
		return firstGo;
	}
}
