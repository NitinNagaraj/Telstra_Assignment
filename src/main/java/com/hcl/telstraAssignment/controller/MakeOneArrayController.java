package com.hcl.telstraAssignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.hcl.telstraAssignment.model.RestResponseModel;
import com.hcl.telstraAssignment.service.MakeOneArrayService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "MakeOneArray")
public class MakeOneArrayController {
	private Logger LOGGER = LoggerFactory.getLogger(MakeOneArrayController.class);
	@Autowired
	private MakeOneArrayService makeOneArrayService;

	@ApiOperation(value = "Merges all arrays into one", notes = "Program to combine all arrays into one by removing duplicates and maintaining order")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successs") })
	@RequestMapping(value = "/api/makeonearray", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> makeOneArray(@RequestBody RestRequestModel restRequest) {
		LOGGER.info("makeOneArray: Inside the makeOneArray method of MakeOneArrayController");
		RestResponseModel restResponse = makeOneArrayService.makeOneArray(restRequest);
		LOGGER.debug("The final response from the service is:" + restResponse.getArray1().toString());
		return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
				.header("expires", "-1").body(restResponse);

	}

}
