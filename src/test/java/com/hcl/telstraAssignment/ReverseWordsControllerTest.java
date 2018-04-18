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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.telstraAssignment.controller.ReverseWordsController;
import com.hcl.telstraAssignment.service.ReverseWordsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReverseWordsControllerTest {

	private String sentence = "How are you";

	private String testString = "test";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ReverseWordsController reverseWordsController;

	@InjectMocks
	private ReverseWordsService reverseWordsService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(reverseWordsController).build();
	}

	@Test
	public void testSuccessfulWordsReversal() throws Exception {
		mockMvc.perform(get("/api/ReverseWords").param("sentence", sentence)).andExpect(status().isOk());
	}

	@Test
	public void testFailureScenario() throws Exception {
		assertNotEquals("test", reverseWordsService.reverseWords(sentence));
	}

	@Test
	public void testSuccessScenario() throws Exception {
		assertEquals("tset ", reverseWordsService.reverseWords(testString));
	}

	@Test
	public void testReverseWordsScenario2() throws Exception {
		mockMvc.perform(get("/api/ReverseWords").param("sentence", "how are you")).andExpect(status().isOk());
	}

	@Test
	public void testReverseWordsExceptionScenario3() throws Exception {
		try {
			mockMvc.perform(get("/api/ReverseWords").param("sentence", " "));
		} catch (NullPointerException ne) {

		}

	}

}
