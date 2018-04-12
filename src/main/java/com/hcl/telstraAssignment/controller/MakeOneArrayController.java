package com.hcl.telstraAssignment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.telstraAssignment.model.RestRequestModel;
import com.hcl.telstraAssignment.service.MakeOneArrayService;
import com.hcl.telstraAssignment.utils.MakeOneArrayServiceUtil;

@RestController
public class MakeOneArrayController {

	@Autowired
	private MakeOneArrayService makeOneArrayService;

	@RequestMapping(value = "/api/makeonearray", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> makeOneArray(@RequestBody RestRequestModel restRequest) {

		Map<String, List<Integer>> finalResult = new HashMap<>();
		MakeOneArrayServiceUtil restResponse = makeOneArrayService.makeOneArray(restRequest);
		finalResult.put("Array", restResponse.getResultList());
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.body(finalResult);

	}

}
