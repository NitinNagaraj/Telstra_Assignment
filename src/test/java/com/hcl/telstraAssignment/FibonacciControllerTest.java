package com.hcl.telstraAssignment;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	@Mock
	private FibonacciController fibonacciController;
	
	@InjectMocks
	private FibonacciService fibonacciService;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(fibonacciController)
                .build();
    }

	
	@Test
	public void testTen() throws Exception {
		mockMvc.perform(get("/api/Fibonacci").param("n", num))
		.andExpect(status().isOk());
	}
	
	
}
