package main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		JSONArray jsonArray = readJson("word-list.json");

		
		double random = Math.random();
		Integer adjustedRandom = (int)(random * jsonArray.size());

		System.out.println("This is the random word which I'm showing to make testing easier");
		System.out.println(jsonArray.get(adjustedRandom));
		String randomWord = (String) jsonArray.get(adjustedRandom);
		
		int guessesUsed = 0;
		boolean win = false;
		
		int guessesAllowed = 6;
		Scanner s = new Scanner(System.in);
		while(guessesUsed < guessesAllowed) {

			System.out.println("");
			System.out.println("please type your " + (guessesUsed + 1) + " guess");
			String guessWord = s.next();
			if(guessWord.length() != 5) {
				System.out.println("Guess must be five letters long.");				
			}
			else {
				int correctLetters = 0;
				System.out.println("For guess " + (guessesUsed + 1) + " you got:");
				for(int guessLetterNumber = 0; guessLetterNumber < guessWord.length(); guessLetterNumber++) {
					boolean letterInWord = false;
					for(int answerLetterNumber = 0; answerLetterNumber < randomWord.length(); answerLetterNumber++) {
						if(guessWord.charAt(guessLetterNumber) == randomWord.charAt(answerLetterNumber)) {
							letterInWord = true;
						}
					}
					
					if(guessWord.charAt(guessLetterNumber) == randomWord.charAt(guessLetterNumber)) {
						correctLetters++;
						System.out.println((guessLetterNumber + 1) + ": " + guessWord.charAt(guessLetterNumber) + " is correct");
					}
					else if(letterInWord) {
						System.out.println((guessLetterNumber + 1) + ": " + guessWord.charAt(guessLetterNumber) + " is correct but in the wrong location");						
					}
					else {	
						System.out.println((guessLetterNumber + 1) + ": " + guessWord.charAt(guessLetterNumber) + " is not in the word");
					}

				}
				if(correctLetters == 5) {
					win = true;
					guessesUsed = guessesAllowed;
				} 
				else {
					guessesUsed++;
				}
			}
		}
		if (win) {
			System.out.println("YOU WON");
		}
		else {
			System.out.println("YOUR OUT OF GUESSES");
			System.out.println("YOU LOST");
			
		}
	}
	
	public static JSONArray readJson (String jsonPath) {
		JSONParser jsonP = new JSONParser();
		
		try(FileReader JsonReader = new FileReader(jsonPath)){

			Object obj = jsonP.parse(JsonReader);
			JSONArray jsonArray = (JSONArray) obj;
//			System.out.println(jsonArray);
			return jsonArray;
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	

	
}
