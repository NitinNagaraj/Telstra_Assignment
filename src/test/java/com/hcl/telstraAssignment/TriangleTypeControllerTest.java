/*package com.hcl.telstraAssignment;

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
        mockMvc = MockMvcBuilders.standaloneSetup(triangleTypeController)
                .build();
    }
	
	@Test
	public void testTriangleTypeForEquilateral() throws Exception {
		mockMvc.perform(get("/api/TriangleType?a=1&b=1&c=1"))
		.andExpect(status().isOk());
	}

}
*/