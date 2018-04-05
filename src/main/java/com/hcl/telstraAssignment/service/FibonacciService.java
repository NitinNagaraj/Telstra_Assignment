package com.hcl.telstraAssignment.service;

import org.springframework.stereotype.Component;


@Component
public class FibonacciService {
	
	/**
	 * To find the nth Fibonacci number
	 * 
	 * @param fib
	 * @return nth fibonacci number
	 */
	
	public long getNthFibonacciNumber(long fib) {
		int num1 = 1;
		int num2 = 0;
		
		if(fib < 0) {
			throw new IllegalArgumentException ("Wrong input: " + fib);
		}
		
		for(int i = 0; i <= fib; i++) {
			int FibNum = num1 + num2;
			num1 = num2;
			num2 = FibNum;
		}
		return num1;
	}

}
