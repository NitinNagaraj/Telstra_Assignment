package com.hcl.telstraAssignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FibonacciService {

	/**
	 * To find the nth Fibonacci number
	 * 
	 * @param nthIndexOfFib
	 * @return nth fibonacci number
	 * @throws InvalidInputException
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciService.class);

	public int getNthFibonacciNumber(long nthIndexOfFib) {
		LOGGER.info("getNthFibonacciNumber: Inside the getNthFibonacciNumber method");
		// taking 2 temporary variables to carry out the operation
		LOGGER.debug("The value of the parameter is: " + nthIndexOfFib);
		int tempNum1 = 1;
		int tempNum2 = 0;
		for (int i = 0; i <= nthIndexOfFib; i++) {
			int FibNum = tempNum1 + tempNum2;
			tempNum1 = tempNum2;
			tempNum2 = FibNum;
		}
		return tempNum1;
	}

}
