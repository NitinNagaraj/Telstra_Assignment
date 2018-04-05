package com.hcl.telstraAssignment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.telstraAssignment.controller.FibonacciController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelstraAssignmentApplicationTests {
	
	@Autowired
	private FibonacciController fibonacciController;
	
	@Test
	public void contextLoads() {
		assertNotNull(fibonacciController);
	}

}
