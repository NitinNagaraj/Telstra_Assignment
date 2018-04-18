package com.hcl.telstraAssignment.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResponseModel implements Serializable {

	private static final long serialVersionUID = 7625748343752321519L;

	public RestResponseModel() {

	}

	public RestResponseModel(Object[] array1) {

		this.array1 = array1;

	}

	@JsonProperty("Array")
	private Object[] array1;

	public Object[] getArray1() {
		return array1;
	}

	public void setArray1(Object[] array1) {
		this.array1 = array1;
	}

}
