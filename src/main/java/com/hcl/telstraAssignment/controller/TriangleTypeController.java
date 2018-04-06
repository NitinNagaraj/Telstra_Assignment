package com.hcl.telstraAssignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.telstraAssignment.service.TriangleTypeService;

@RestController
@RequestMapping("/api")
public class TriangleTypeController {

	@Autowired
	private TriangleTypeService triangleTypeService;

	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	public ResponseEntity<Object> getTriangleType(@RequestParam("a") Object sideLength1,
			@RequestParam("b") Object sideLength2, @RequestParam("c") Object sideLength3) {
		try {
			// converting the input to integer type before getting the triangle type
			Integer side1 = new Integer(sideLength1.toString());
			Integer side2 = new Integer(sideLength2.toString());
			Integer side3 = new Integer(sideLength3.toString());
			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").body(triangleTypeService.getTriangleType(side1, side2, side3));
		} catch (NumberFormatException numberException) {
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", "Invalid input entered");
			return ResponseEntity.badRequest().body(response);
		}
	}

}
