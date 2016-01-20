package logic;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {


	@Test
	public void testConstructorCreatesObjects()
	{
		Game game = new Game();
		assertNotNull(game.getGrid());
		assertNotNull(game.getWords());
	}

}
