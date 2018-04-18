package com.hcl.telstraAssignment.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestRequestModel {

	@JsonProperty("Array1")
	List<Integer> array1;

	@JsonProperty("Array2")
	List<Integer> array2;

	@JsonProperty("Array3")
	List<Integer> array3;

	@JsonProperty("Array4")
	List<Integer> array4;

	@JsonProperty("Array5")
	List<Integer> array5;

	@JsonProperty("Array6")
	List<Integer> array6;

	@JsonProperty("Array7")
	List<Integer> array7;

	@JsonProperty("Array8")
	List<Integer> array8;

	@JsonProperty("Array9")
	List<Integer> array9;

	@JsonProperty("Array10")
	List<Integer> array10;

	public List<Integer> getArray1() {
		return array1;
	}

	public void setArray1(List<Integer> array1) {
		this.array1 = array1;
	}

	public List<Integer> getArray2() {
		return array2;
	}

	public void setArray2(List<Integer> array2) {
		this.array2 = array2;
	}

	public List<Integer> getArray3() {
		return array3;
	}

	public void setArray3(List<Integer> array3) {
		this.array3 = array3;
	}

	public List<Integer> getArray4() {
		return array4;
	}

	public void setArray4(List<Integer> array4) {
		this.array4 = array4;
	}

	public List<Integer> getArray5() {
		return array5;
	}

	public void setArray5(List<Integer> array5) {
		this.array5 = array5;
	}

	public List<Integer> getArray6() {
		return array6;
	}

	public void setArray6(List<Integer> array6) {
		this.array6 = array6;
	}

	public List<Integer> getArray7() {
		return array7;
	}

	public void setArray7(List<Integer> array7) {
		this.array7 = array7;
	}

	public List<Integer> getArray8() {
		return array8;
	}

	public void setArray8(List<Integer> array8) {
		this.array8 = array8;
	}

	public List<Integer> getArray9() {
		return array9;
	}

	public void setArray9(List<Integer> array9) {
		this.array9 = array9;
	}

	public List<Integer> getArray10() {
		return array10;
	}

	public void setArray10(List<Integer> array10) {
		this.array10 = array10;
	}

}