package com.hcl.telstraAssignment.service;

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

	public int getNthFibonacciNumber(long nthIndexOfFib) {
		// taking 2 temporary variables to carry out the operation
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
