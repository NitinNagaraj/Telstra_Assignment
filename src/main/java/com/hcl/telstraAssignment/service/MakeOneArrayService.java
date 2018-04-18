package com.hcl.telstraAssignment.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hcl.telstraAssignment.model.RestRequestModel;
import com.hcl.telstraAssignment.model.RestResponseModel;

@Service
public class MakeOneArrayService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MakeOneArrayService.class);
	List<Integer> resultList = new ArrayList<>();

	public RestResponseModel makeOneArray(RestRequestModel request) {

		LOGGER.info("makeOneArray: Inside the makeOneArray method");
		SortedSet<Integer> array = new TreeSet<Integer>();
		LOGGER.debug("The values of request object is: " + request.getValues());
		List<List<Integer>> list = new ArrayList<List<Integer>>(request.getValues().values());
		Iterator<List<Integer>> iterator = list.iterator();

		while (iterator.hasNext()) {
			array.addAll(iterator.next());
		}
		RestResponseModel resp = new RestResponseModel();
		resp.setArray1(array.toArray());
		LOGGER.debug("The value of the response object is: " + resp.toString());
		return resp;
	}
}
