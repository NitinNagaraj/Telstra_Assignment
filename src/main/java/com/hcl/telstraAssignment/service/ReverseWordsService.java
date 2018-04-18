package com.hcl.telstraAssignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * To reverse the given string in the sentence
 * 
 * @param sentence
 * @return reversed string
 */
@Service
public class ReverseWordsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseWordsService.class);

	public String reverseWords(String sentence) {
		// temporary variables to hold the reversed String and the words in the
		// sentence.
		LOGGER.info("reverseWords: Inside the reverseWords method");
		StringBuilder reversedString = new StringBuilder();
		String[] arrayOfWords = sentence.split(" ");
		LOGGER.debug("The length of the sentence is: " + arrayOfWords.length);
		for (String word : arrayOfWords) {
			StringBuilder reversedWord = new StringBuilder();
			String punctutations = "!@#$%^&*()_+?.";
			String last_letter = "";
			if (punctutations.contains(word.substring(word.length() - 1))) {
				last_letter = word.substring(word.length() - 1);
				word = word.replace(word.substring(word.length() - 1), "");
			}
			for (int i = word.length() - 1; i >= 0; i--) {
				reversedWord.append(word.charAt(i));
			}
			reversedString.append(reversedWord).append(last_letter).append(" ");
		}
		LOGGER.debug("The length of the reversed sentence is: " + reversedString.length());
		return reversedString.toString();

	}
}
