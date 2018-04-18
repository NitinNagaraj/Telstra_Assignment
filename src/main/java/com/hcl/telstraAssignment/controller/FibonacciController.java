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

import com.hcl.telstraAssignment.service.FibonacciService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "FibonacciSeries")
@RequestMapping("/api")
public class FibonacciController {
	private final Logger LOGGER = LoggerFactory.getLogger(FibonacciController.class);
	@Autowired
	private FibonacciService fibonacciService;

	@ApiOperation(value = "Returns the nth index in the Fibonacci series", notes = "Program to calculate the nth index of the Fibonacci series")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Invalid Input: Please input a number to get a proper output") })
	@RequestMapping(value = "/Fibonacci", method = RequestMethod.GET)
	public ResponseEntity<Object> getNthFibonacciNumber(@RequestParam("n") Object nthIndexOfFibNum) {
		LOGGER.info("getNthFibonacciNumber: Inside the getNthFibonacciNumber method");
		try {
			// converting the input to long type before getting the nth index
			Long limit = new Long(nthIndexOfFibNum.toString());
			LOGGER.debug("The value of the nth index entered is:" + limit);
			if (limit <= 0) {
				throw new IllegalArgumentException("The number has to be a positive integer greater than zero");
			}
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").header("expires", "-1")
					.body(fibonacciService.getNthFibonacciNumber(limit));
			// Throw an invalid exception if the input is not proper
		} catch (NumberFormatException numberException) {
			LOGGER.error("getNthFibonacciNumber: Exception encountered ::" + numberException.getMessage());
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", "Invalid input entered");
			return ResponseEntity.badRequest().body(response);
		} catch (IllegalArgumentException invalidInputException) {
			LOGGER.error("getNthFibonacciNumber: Invalid input :: " + invalidInputException.getMessage());
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", invalidInputException.getMessage());
			return ResponseEntity.badRequest().body(response);
		}

	}
}
