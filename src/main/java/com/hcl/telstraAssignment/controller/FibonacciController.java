package com.hcl.telstraAssignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.telstraAssignment.service.FibonacciService;

@RestController
@RequestMapping("/api")
public class FibonacciController {

	@Autowired
	private FibonacciService fibonacciService;

	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	public ResponseEntity<Object> getNthFibonacciNumber(@RequestParam("n") Object nthIndexOfFibNum) {

		try {
			// converting the input to long type before getting the nth index
			Long limit = new Long(nthIndexOfFibNum.toString());
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").body(fibonacciService.getNthFibonacciNumber(limit));
			// Throw an invalid exception if the input is not proper
		} catch (NumberFormatException numberException) {
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", "Invalid input entered");
			return ResponseEntity.badRequest().body(response);
		}

	}
}
