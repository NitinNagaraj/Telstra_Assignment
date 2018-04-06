package com.hcl.telstraAssignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
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
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@Mock
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
	public void testTriangleTypePositiveScenarioWhenTriangleIsIsosceles() throws Exception {
		given(this.triangleTypeController.getTriangleType("2", "1", "1"))
				.willReturn(ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
						.header("Pragma", "no-cache").body("Isosceles"));
	}

	@Test
	public void testTriangleTypePositiveScenarioWhenTriangleIsEquilateral() throws Exception {
		given(this.triangleTypeController.getTriangleType("2", "2", "2"))
				.willReturn(ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
						.header("Pragma", "no-cache").body("Equilateral"));
	}

	@Test
	public void testTriangleTypePositiveScenarioWhenTriangleIsScalene() throws Exception {
		given(this.triangleTypeController.getTriangleType("2", "3", "4"))
				.willReturn(ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
						.header("Pragma", "no-cache").body("Scalene"));
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

}
