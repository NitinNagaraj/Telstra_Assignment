package com.hcl.telstraAssignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hcl.telstraAssignment.model.RestRequestModel;
import com.hcl.telstraAssignment.model.RestResponseModel;
import com.hcl.telstraAssignment.service.MakeOneArrayService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MakeOneArrayControllerTest {

	@MockBean
	private MakeOneArrayService makeOneArrayService;

	@Autowired
	private MockMvc mockMvc;

	RestResponseModel mockOneArrayResponse = new RestResponseModel(new Object[] { 0, 1, 2, 3, 6, 7, 8, 9, 23, 45, 90 });
	String mockOneArrayRequest = "{\"Array1\":[1,2,3,45],\"Array2\":[7,9,0,6,8,23],\"Array3\":[90,23,1,2,3]}";

	@Test
	public void testMakeonearray() throws Exception {

		Mockito.when(makeOneArrayService.makeOneArray(Mockito.any(RestRequestModel.class)))
				.thenReturn(mockOneArrayResponse);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/makeonearray").accept(MediaType.APPLICATION_JSON)
				.content(mockOneArrayRequest).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("{\"Array\":[0,1,2,3,6,7,8,9,23,45,90]}"));

	}
}
