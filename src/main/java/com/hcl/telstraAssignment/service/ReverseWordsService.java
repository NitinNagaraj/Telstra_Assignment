package com.hcl.telstraAssignment.service;

import org.springframework.stereotype.Service;

/**
 * To reverse the given string in the sentence
 * 
 * @param sentence
 * @return reversed string
 */
@Service
public class ReverseWordsService {

	public String reverseWords(String sentence) {
		// temporary variables to hold the reversed String and the words in the
		// sentence.
		String reversedString = "";
		String[] arrayOfWords = sentence.split(" ");
		for (String word : arrayOfWords) {
			String reversedWord = "";
			for (int i = word.length() - 1; i >= 0; i--) {
				reversedWord += word.charAt(i);
			}
			reversedString += reversedWord;
			reversedString += " ";
		}
		return reversedString;

	}
}
