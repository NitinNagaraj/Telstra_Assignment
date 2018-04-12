package com.hcl.telstraAssignment.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MakeOneArrayServiceUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8412739676410641790L;
	private List<Integer> resultList = new ArrayList<>();

	public List<Integer> getResultList() {
		return resultList;
	}

	public void setResultList(List<Integer> resultList) {
		this.resultList = resultList;
	}

}
