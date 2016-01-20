package logic;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WordTest {
	
	//TODO - What if the wordList is less than 25 unique words?
	
	@Test
	public void testBuilder() throws IOException
	{
		//Check length
		//Check not null
		//Check not 2 characters.
		
		Word[] words = Word.buildList();
		
		assertEquals(25, words.length);
		
		for(Word str: words)
		{
			assertNotNull(str);
			assertTrue(str.getWordString().length() > 2);
		}	
	}
	
	
	@Test
	public void testCheckWordValidTooSmall()
	{
		Word[] list = new Word[25];
		assertFalse(Word.isWordValid(list, ""));
		assertFalse(Word.isWordValid(list, "a"));
		assertFalse(Word.isWordValid(list, "aa"));
		assertTrue(Word.isWordValid(list, "aaa"));
	}
	
	@Test
	public void testCheckWordValidInList()
	{
		Word[] list = new Word[25];
		list[23] = new Word("test");
		assertFalse(Word.isWordValid(list, "test"));
		assertTrue(Word.isWordValid(list, "aaa"));
	}

}
