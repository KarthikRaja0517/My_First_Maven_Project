package com.fssa.karthik_raja.projectobject;

import java.util.regex.Pattern;

/**
 * 
 * @author KarthikRajaPooraja
 * FlashCardValidator to provide validations for the attributes in the user class.
 *It consists of the following ones
 *Flashcard class to declare,set and get the attributes;
 * validate method for overall validation;
 * Validate word method to validate word;
 * Validate meaning method to validate meaning;
 * Validate synonym method to validate Synonym;
 * Validate Example method to validate Example;
 * 
 */
class FlashCard {
//	Declaring attributes present in the object
	String word;
	String meaning;
	String synonyms;
	String example;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
}


public class FlashCardValidator {
//passing flashcard as an object to validate method
	public static boolean validate(FlashCard card){

		// intial check whether the object is null or not
		if (card == null) {
			throw new IllegalArgumentException("Argument is NULL");
		}
       // creating individual methods to enhance the testing process
		validateWord(card.getWord());
		validateMeaning(card.getMeaning());
		validateSynonym(card.getSynonyms());
		validateExample(card.getExample());
		return true;		
		}
    
	public static boolean validateWord(String input) throws IllegalArgumentException {
//		preliminary check of the word input (empty or null)
	    if (input == null || input.trim().isEmpty()) {
	        throw new IllegalArgumentException("Input is empty or null.");
	    }
// to validate whether the word is in the required length or not
	    if(!(input.length() >= 2 && input.length() < 45)) {
	    	throw new IllegalArgumentException("Input must have atleast 2 char to 45 char");
	    }
//	    Basic grammatical check (whether it starts with capital letter or not)
	    if (!Character.isUpperCase(input.charAt(0))) {
	        throw new IllegalArgumentException("Input must start with an uppercase letter.");
	    }
//	    Regex patter to validate word (contains only uppercase and lowercase letters,it should not contain numbers or spaces)
	    if (!input.matches("[a-zA-Z\\s]+")) {
	        throw new IllegalArgumentException("Input must not contain special characters or numbers.");
	    }
	    return true;
	}


    public static boolean validateMeaning(String meaning)throws IllegalArgumentException {
//		preliminary check of the word input (empty or null)   	
    	if (meaning == null|| "".equals(meaning.trim()) ) {
			throw new IllegalArgumentException("Meaning input is empty or NULL");
		}
//	    Basic grammatical check (whether it starts with capital letter or not)    	
    	if (!Character.isUpperCase(meaning.charAt(0))) {
	        throw new IllegalArgumentException("Meaning input should start with a capital letter");
	    }
//      Regex pattern to validate  meaning (It should not contain special characters
    	if (!meaning.matches("[a-zA-Z0-9\\s]+")) {
	        throw new IllegalArgumentException("Meaning input should not contain any special characters");
	    }
    	return true;
    }
    public static boolean validateSynonym(String synonym)throws IllegalArgumentException {
//		preliminary check of the word input (empty or null)    	
    	if (synonym == null|| "".equals(synonym.trim()) ) {
			throw new IllegalArgumentException("Synonym input should not be null or empty");
		}
//	    Basic grammatical check (whether it starts with capital letter or not)
    	if (!Character.isUpperCase(synonym.charAt(0))) {
	        throw new IllegalArgumentException("Synonym input should start with capital letter");
	    }
//      Regex pattern for synonym 
//  	It should have three words separated by two colon and it should not contain numbers or special Characters
    	String synonymRegex="^[A-Z]\\w+\\,\\w+\\,\\w+$";
    	boolean isMatch=Pattern.matches(synonymRegex, synonym);
    	if (!isMatch) {
    		throw new IllegalArgumentException("Synonym input doesn't match the required format");
    	}
    	return true;
    }
    
    
    public static boolean validateExample(String example)throws IllegalArgumentException {
//		preliminary check of the word input (empty or null)   	
    	if (example == null|| "".equals(example.trim()) ) {
			throw new IllegalArgumentException("Example input should not be null or empty");
		}
//	    Basic grammatical check (whether it starts with capital letter or not)    	
    	if (!Character.isUpperCase(example.charAt(0))) {
	        throw new IllegalArgumentException("Example must start with an uppercase letter.");
	    }
//      Regex pattern to validate example (it should not contain special characters)
    	if (!example.matches("[a-zA-Z0-9\\s]+")) {
	        throw new IllegalArgumentException("Example input should not contain any special characters");
	    }
    	return true;
    }

}
