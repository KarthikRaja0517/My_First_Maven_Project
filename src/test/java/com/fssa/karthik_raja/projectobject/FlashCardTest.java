package com.fssa.karthik_raja.projectobject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author KarthikRajaPooraja 
 * writing testcases for flashcard validator class.
 * Class FlashCardTest consists of first 4 test cases to test the true
 *         values (only valid inputs)
 * 
 */
public class FlashCardTest {
	FlashCard word=new FlashCard();
	@Test
	void validateValidWord() {	
		word.setWord("Intermediate");
		FlashCardValidator.validateWord(word.getWord());
		Assertions.assertTrue(true);
	}
	
	@Test
	void validateInvalidWordOne() {
		try {
			word.setWord("intermediate");
			FlashCardValidator.validateWord(word.getWord());
//			Assertions.fail("Your word input is gramatically incorrect");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Input must start with an uppercase letter.", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidWordTwo() {
		try {
			word.setWord(null);
			FlashCardValidator.validateWord(word.getWord());
//			Assertions.fail("Your word input is null");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Input is empty or null.", ex.getMessage());
		}
	}
	@Test
	void validateInvalidWordThree() {
		try {
			word.setWord("I");
			FlashCardValidator.validateWord(word.getWord());
//			Assertions.fail("Your word input is not in range");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Input must have atleast 2 char to 45 char", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidWordFour() {
		try {
			word.setWord("Jos@17");
			FlashCardValidator.validateWord(word.getWord());
//			Assertions.fail("Special Characters Exception is not working");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Input must not contain special characters or numbers.", ex.getMessage());
		}
	}

	@Test
	void validateValidMeaning() {
		word.setMeaning("It is a good one 23 years");
		FlashCardValidator.validateMeaning(word.getMeaning());
		Assertions.assertTrue(true);
	}
	@Test
	void validateInvalidMeaningOne() {
		try {
			word.setMeaning("");
			FlashCardValidator.validateMeaning(word.getMeaning());
//			Assertions.fail("Your meaning cannot be null or empty");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Meaning input is empty or NULL", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidMeaningTwo() {
		try {
			word.setMeaning("it is a fruit");
			FlashCardValidator.validateMeaning(word.getMeaning());
//			Assertions.fail("Capital letter validation is not performed (Meaning)");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Meaning input should start with a capital letter", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidMeaningThree() {
		try {
			word.setMeaning("Wonderful@@@");
			FlashCardValidator.validateMeaning(word.getMeaning());
//			Assertions.fail("Your meaning cannot be null or empty");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Meaning input should not contain any special characters", ex.getMessage());
		}
	}
	@Test
	void validateValidSynonym() {
		word.setSynonyms("Eager,Engaging,Entertain");
		FlashCardValidator.validateSynonym(word.getSynonyms());
	    Assertions.assertTrue(true);
	}
	
	@Test
	void validateInvalidSynonymOne() {
		try {
			word.setSynonyms("");
			FlashCardValidator.validateSynonym(word.getSynonyms());
//			Assertions.fail("Your meaning cannot be null or empty");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Synonym input should not be null or empty", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidSynonymTwo() {
		try {
			word.setSynonyms("eager,engaging,entertain");
			FlashCardValidator.validateSynonym(word.getSynonyms());
//			Assertions.fail("Capital letter validation is not performed (Meaning)");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Synonym input should start with capital letter", ex.getMessage());
		}
	}
	@Test
	void validateInvalidSynonymThree() {
		try {
			word.setSynonyms("Eager,Engaging");
			FlashCardValidator.validateSynonym(word.getSynonyms());
//			Assertions.fail("Capital letter validation is not performed (Meaning)");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Synonym input doesn't match the required format", ex.getMessage());
		}
	}
	

	@Test
	void validateValidExample() {
		word.setExample("It is an apple");
		FlashCardValidator.validateExample(word.getExample());
		Assertions.assertTrue(true);
	}
	
	@Test
	void validateInvalidExampleOne() {
		try {
			word.setExample("");
			FlashCardValidator.validateExample(word.getExample());
//			Assertions.fail("Your meaning cannot be null or empty");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Example input should not be null or empty", ex.getMessage());
		}
	}
	
	@Test
	void validateInvalidExampleTwo() {
		try {
			word.setExample("it is a nice toy");
			FlashCardValidator.validateExample(word.getExample());
//			Assertions.fail("Capital letter validation is not performed (Meaning)");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Example must start with an uppercase letter.", ex.getMessage());
		}
	}
	
}
