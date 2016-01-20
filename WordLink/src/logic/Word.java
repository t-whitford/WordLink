package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Class exists in case of deciding to expand the program to control the game
 * markers on the words. Currently we will let the users control this.
 * 
 * @author Tom
 *
 */
public class Word {
	
	String word;
	
	/**
	 * 
	 * @param word The string that makes the word
	 */
	public Word(String word)
	{
		this.word = word;
	}
	
	
	/**
	 * Creates a list of 25 random words from the word list
	 * @return array of 25 random Words
	 */
	public static Word[] buildList()
	{
		//First line is number of words in the file
		Word[] list = new Word[25];
		String[] fullList;
		
		File file = new File(".\\Resources\\tempList");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));

		
		
		int fullListSize = Integer.parseInt(br.readLine());
		fullList = new String[fullListSize];
		
		for(int i = 0; i < fullList.length; i++)
		{
			fullList[i] = br.readLine();
		}
		
		
		Random rand = new Random();
		for(int i = 0; i < 25; i++)
		{
			String temp;
			do
				temp = fullList[rand.nextInt(fullListSize)];
			while(!isWordValid(list, temp));
		
			list[i] = new Word(temp);
		}
		br.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	/**
	 * Method to check that a word from the word list is valid
	 * @param list The word list so far - to check for clashes
	 * @param toCheck The string to check
	 * @return True if the word is allowed, false if not.
	 */
	public static boolean isWordValid(Word[] list, String toCheck) {
		//Check length
		//Check not already in list
		
		if(toCheck.length() < 3)
			return false;
		
		for(Word word: list)
		{
			if(word != null && word.getWordString().compareTo(toCheck) == 0)
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @return Return a string that represents the word
	 */
	public String getWordString() {
		return word;
	}


}
