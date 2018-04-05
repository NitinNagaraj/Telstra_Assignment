package com.hcl.telstraAssignment.controller;

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
	public ResponseEntity<String> fetchTriangleType(@RequestParam("a")  int sideLength1,@RequestParam("b")  int sideLength2,@RequestParam("c")  int sideLength3) {
		return ResponseEntity.status(HttpStatus.OK)
                .cacheControl(CacheControl.noCache()).header("Pragma", "no-cache")
                .body(triangleTypeService.getTriangleType(sideLength1, sideLength2, sideLength3));
	}
	
}
