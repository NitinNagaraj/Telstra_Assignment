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

import com.hcl.telstraAssignment.controller.TriangleTypeController;
import com.hcl.telstraAssignment.service.TriangleTypeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleTypeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TriangleTypeController triangleTypeController;

	@InjectMocks
	private TriangleTypeService triangleTypeService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(triangleTypeController).build();
	}

	@Test
	public void testSuccessScenario1() throws Exception {
		mockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
				.andExpect(status().is(200));
	}

	@Test
	public void testForTriangleTypeEquilateral() {
		assertEquals("Equilateral", triangleTypeService.getTriangleType(2, 2, 2));
	}

	@Test
	public void testForTriangleTypeEquilateralFailureScenario() {
		assertNotEquals("Equilateral", triangleTypeService.getTriangleType(2, 1, 2));
	}

	@Test
	public void testForTriangleTypeIsosceles() {
		assertEquals("Isosceles", triangleTypeService.getTriangleType(1, 2, 2));
	}

	@Test
	public void testForTriangleTypeIsoscelesFailureScenario() {
		assertNotEquals("Isosceles", triangleTypeService.getTriangleType(1, 3, 2));
	}

	@Test
	public void testForTriangleTypeScalene() {
		assertEquals("Scalene", triangleTypeService.getTriangleType(2, 3, 4));
	}

	@Test
	public void testForTriangleTypeScaleneFailureScenario() {
		assertNotEquals("Scalene", triangleTypeService.getTriangleType(2, 2, 2));
	}

	@Test
	public void testTriangleTypeSCenario1() throws Exception {
		mockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
				.andExpect(status().is(200));
	}

	@Test
	public void testTriangleTypeExceptionScenario() throws Exception {
		try {
			triangleTypeController.getTriangleType(new String("abc"), new String("abc"), new String("abc"));
		} catch (NumberFormatException e) {

		}
	}

	@Test
	public void testTriangleTypeExceptionScenario2() throws Exception {
		try {
			mockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "12"));
		} catch (IllegalArgumentException ie) {

		}

	}

	@Test
	public void testTriangleTypeExceptionScenario3() throws Exception {
		try {
			mockMvc.perform(get("/api/TriangleType").param("a", "0").param("b", "0").param("c", "0"));
		} catch (IllegalArgumentException ie) {

		}

	}

}
