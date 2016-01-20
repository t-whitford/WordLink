package logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GridTest {

	@Test
	public void testConstructorGridNotEmpty()
	{
		Grid grid = new Grid();
		Colour[] colours = grid.getAllColours();
		
		for(Colour c: colours)
		{
			assertNotNull(c);
		}
	}
	
	@Test
	public void testConstructorNumberOfColours()
	{
		Grid grid = new Grid();
		Colour[] colours = grid.getAllColours();
		
		int expRed = 7;
		int expBlue = 7;
		int expGrey = 10;
		
		int numRed = 0;
		int numBlue = 0;
		int numGrey = 0;
		
		for(Colour c: colours)
		{
			switch (c) {
			case RED:
				numRed++;
				break;
			case BLUE:
				numBlue++;
				break;
			case GREY:
				numGrey++;
				break;
			default:
				fail();
			}
		}
		
		if(grid.getFirstGoColour() == Colour.RED)
			expRed++;
		else if(grid.getFirstGoColour() == Colour.BLUE)
			expBlue++;
		else
			fail();
		
		assertEquals(expRed, numRed);
		assertEquals(expBlue, numBlue);
		assertEquals(expGrey, numGrey);
	}
	
}
