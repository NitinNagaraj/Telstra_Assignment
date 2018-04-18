package com.hcl.telstraAssignment.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * To return Three types of triangle - Equilateral, Isoceles or Scalene
 * 
 * @param sideLength1
 * @param sideLength2
 * @param sideLength3
 * @return type of triangle as a String value
 */

@Service
public class TriangleTypeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TriangleTypeService.class);

	public String getTriangleType(int sideLength1, int sideLength2, int sideLength3) {
		LOGGER.info("getTriangleType : Inside the getTriangleType method");
		// to check for the negative values
		LOGGER.debug("The value of the side 1, side2 and side3 respectively are :" + sideLength1 + "," + sideLength2
				+ "and" + sideLength3);
		// to check if the triangle is equilateral
		if (sideLength1 == sideLength2 && sideLength2 == sideLength3) {
			return "Equilateral";
		}
		// to check if the triangle is iscoceles
		else if (sideLength1 == sideLength2 || sideLength2 == sideLength3 || sideLength1 == sideLength3) {
			return "Isosceles";
		}
		// to check if the triangle is scalene
		else {
			return "Scalene";
		}
	}

}
