package com.hcl.telstraAssignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.telstraAssignment.service.ReverseWordsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "ReverseWords")
@RequestMapping("/api")
public class ReverseWordsController {
	private Logger LOGGER = LoggerFactory.getLogger(ReverseWordsController.class);
	@Autowired
	private ReverseWordsService reverseWordsService;

	// This project accepts a String variable and returns a reversed string
	@ApiOperation(value = "Reverses the words of a sentence", notes = "Program to reverse words in a sentence")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 400, message = "Invalid Input: Please provide a proper input") })
	@RequestMapping(value = "/ReverseWords", method = RequestMethod.GET)
	public ResponseEntity<Object> reverseWords(@RequestParam("sentence") String sentence) {
		LOGGER.info("reverseWords: Inside the reverseWords method of the ReverseWordsController");
		try {
			LOGGER.debug("The sentence passed as parameter is:" + sentence);
			if (sentence.equals(null)) {
				throw new NullPointerException("The input sentence cannot be null");
			}
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").header("expires", "-1")
					.body(reverseWordsService.reverseWords(sentence));
		} catch (NullPointerException nullPointerException) {
			LOGGER.error("reverseWords: Exception encountered :: " + nullPointerException.getMessage());
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", nullPointerException.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}

}
