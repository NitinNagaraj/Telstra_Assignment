package com.hcl.telstraAssignment;

import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.telstraAssignment.controller.MakeOneArrayController;
import com.hcl.telstraAssignment.model.RestRequestModel;
import com.hcl.telstraAssignment.service.MakeOneArrayService;
import com.hcl.telstraAssignment.utils.MakeOneArrayServiceUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MakeOneArrayControllerTest {

	@Mock
	private MakeOneArrayService makeOneArrayService;

	@InjectMocks
	private MakeOneArrayController makeOneArrayController;

	@Autowired
	private MockMvc mockMvc;

	String mockArrayRequest = "{\"Array1\":[1,2,3,4],\"Array2\":[3,4,5,6],\"Array3\":[6,1,3,11]}";

	MakeOneArrayServiceUtil makeOneArrayResponse = new MakeOneArrayServiceUtil();

	List<Integer> list = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(makeOneArrayController).build();
	}

	@Test
	public void testMakeOneArray1() {
		RestRequestModel restRequestModel = new RestRequestModel();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		List<Integer> list4 = new ArrayList<>();
		List<Integer> list5 = new ArrayList<>();
		List<Integer> list6 = new ArrayList<>();
		List<Integer> list7 = new ArrayList<>();
		List<Integer> list8 = new ArrayList<>();
		List<Integer> list9 = new ArrayList<>();
		List<Integer> list10 = new ArrayList<>();
		list1.add(1);
		list1.add(5);
		list1.add(3);
		list1.add(2);

		list2.add(6);
		list2.add(4);
		list2.add(2);
		list2.add(1);

		list3.add(11);
		list3.add(9);
		list3.add(4);
		list3.add(1);

		list4.add(11);
		list4.add(9);
		list4.add(4);
		list4.add(1);

		list5.add(11);
		list5.add(9);
		list5.add(4);
		list5.add(1);

		list6.add(11);
		list6.add(9);
		list6.add(4);
		list6.add(1);

		list7.add(11);
		list7.add(9);
		list7.add(4);
		list7.add(1);

		list8.add(11);
		list8.add(9);
		list8.add(4);
		list8.add(1);

		list9.add(11);
		list9.add(9);
		list9.add(4);
		list9.add(1);

		list10.add(11);
		list10.add(9);
		list10.add(4);
		list10.add(1);

		restRequestModel.setArray1(list1);
		restRequestModel.setArray2(list2);
		restRequestModel.setArray3(list3);
		restRequestModel.setArray4(list4);
		restRequestModel.setArray5(list5);
		restRequestModel.setArray6(list6);
		restRequestModel.setArray7(list7);
		restRequestModel.setArray8(list8);
		restRequestModel.setArray9(list9);
		restRequestModel.setArray10(list10);

		assertNull(makeOneArrayService.makeOneArray(restRequestModel));
	}

	@Test
	public void testScenario1() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/makeonearray"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

}
