package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Extract informations about the content of a file
 */
public class FileParser 
{
	private File file;
	
	
	/**
	 * File to be parsed
	 * 
	 * @param f File with some text
	 */
	public FileParser(File f)
	{
		this.file = f;
	}
	
	
	/**
	 * Extract all upper case words of the file
	 */
	public List<String> getAllUpperCaseWords()
	{
		List<String> response = new ArrayList<>();
		
		try ( BufferedReader br = new BufferedReader(new FileReader(file)) ){
			String line;
			String[] words;
			
			while ( (line = br.readLine()) != null ) {
				words = line.split(" ");
				
				for (String word : words) {
					if (word == word.toUpperCase()) {
						response.add(word);
					}
				}
			}
		} catch (IOException e) {}
		
		return response;
	}
}
