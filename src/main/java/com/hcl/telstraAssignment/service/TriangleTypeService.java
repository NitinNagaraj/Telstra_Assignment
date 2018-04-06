package com.hcl.telstraAssignment.service;

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

	public String getTriangleType(int sideLength1, int sideLength2, int sideLength3) {
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
