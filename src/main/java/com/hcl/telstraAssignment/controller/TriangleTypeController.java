package com.hcl.telstraAssignment.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.telstraAssignment.service.TriangleTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "TriangleTypes")
@RequestMapping("/api")
public class TriangleTypeController {
	private Logger LOGGER = LoggerFactory.getLogger(TriangleTypeController.class);
	@Autowired
	private TriangleTypeService triangleTypeService;

	@ApiOperation(value = "Finds triangle type from its sides", notes = "Operation to find triangle type given its sides")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 404, message = "Invalid Input: Please enter a number as input") })
	@RequestMapping(value = "/TriangleType", method = RequestMethod.GET)
	public ResponseEntity<Object> getTriangleType(@RequestParam("a") Object sideLength1,
			@RequestParam("b") Object sideLength2, @RequestParam("c") Object sideLength3) {
		LOGGER.info("Inside the Triangle type controller");
		try {
			// converting the input to integer type before getting the triangle type
			Integer side1 = new Integer(sideLength1.toString());
			Integer side2 = new Integer(sideLength2.toString());
			Integer side3 = new Integer(sideLength3.toString());
			LOGGER.debug("The value of the side1, side2 and side3 are" + side1 + "," + side2 + "and" + side3
					+ "respectively");
			// to check if the length of the sides are greater than zero
			if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
				LOGGER.error("The length of the sides in a triangle cannot be less than or equal to zero");
				throw new IllegalArgumentException(
						"Length of sides in a triangle cannot be less than or equal to zero");
			}
			// to check if the sum of the length of two sides are not lesser than the other
			// side
			if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
				LOGGER.error("Sum of any two sides must be larger than the remaining side");
				throw new IllegalArgumentException("Sum of any two sides must be larger than the remaining side");
			}

			return ResponseEntity.status(HttpStatus.OK).cacheControl(CacheControl.noCache())
					.header("Pragma", "no-cache").header("expires", "-1")
					.body(triangleTypeService.getTriangleType(side1, side2, side3));
		} catch (NumberFormatException numberException) {
			LOGGER.error("getTriangleType : Number format exception encountered :: " + numberException.getMessage());
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", "Invalid input entered");
			return ResponseEntity.badRequest().body(response);
		} catch (IllegalArgumentException invalidInputException) {
			LOGGER.error("getTriangleType: Invalid input :: " + invalidInputException.getMessage());
			Map<String, String> response = new HashMap<String, String>();
			response.put("error", invalidInputException.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

}
