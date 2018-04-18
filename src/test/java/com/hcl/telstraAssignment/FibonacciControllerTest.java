package com.hcl.telstraAssignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.telstraAssignment.controller.FibonacciController;
import com.hcl.telstraAssignment.service.FibonacciService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	String num = "10";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private FibonacciController fibonacciController;

	@InjectMocks
	private FibonacciService fibonacciService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(fibonacciController).build();
	}

	@Test
	public void testSuccessScenario() {
		assertEquals(89, fibonacciService.getNthFibonacciNumber(11));
	}

	@Test
	public void testFailureScenario() {
		assertNotEquals(89, fibonacciService.getNthFibonacciNumber(10));
	}

	@Test
	public void testScenario1() throws Exception {
		mockMvc.perform(get("/api/Fibonacci").param("n", num)).andExpect(status().isOk());
	}

	@Test
	public void testScenario2() throws Exception {
		this.mockMvc.perform(get("/api/Fibonacci").param("n", num)
				.accept(MediaType.parseMediaType("application/json;charset=UTF-8"))).andExpect(status().isOk());

	}

	@Test
	public void testFibonacciExceptionScenario() throws Exception {
		try {
			fibonacciController.getNthFibonacciNumber(new String("test"));
		} catch (NumberFormatException e) {

		}

	}

	@Test
	public void testFibonacciExceptionScenario2() throws Exception {
		try {
			fibonacciController.getNthFibonacciNumber("-1");
		} catch (IllegalArgumentException ie) {

		}

	}

}
