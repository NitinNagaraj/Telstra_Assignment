package com.hcl.telstraAssignment.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.telstraAssignment.model.RestRequestModel;
import com.hcl.telstraAssignment.utils.MakeOneArrayServiceUtil;

@Service
public class MakeOneArrayService {

	List<Integer> resultList = new ArrayList<>();

	public MakeOneArrayServiceUtil makeOneArray(RestRequestModel request) {

		MakeOneArrayServiceUtil makeOneArrayUtil = new MakeOneArrayServiceUtil();
		ArrayList<Integer> mergedList = new ArrayList<>();
		mergedList.addAll(request.getArray1());
		mergedList.addAll(request.getArray2());
		mergedList.addAll(request.getArray3());
		mergedList.addAll(request.getArray4());
		mergedList.addAll(request.getArray5());
		mergedList.addAll(request.getArray6());
		mergedList.addAll(request.getArray7());
		mergedList.addAll(request.getArray8());
		mergedList.addAll(request.getArray9());
		mergedList.addAll(request.getArray10());
		Collections.sort(mergedList);

		ArrayList<Integer> finalArrayList = new ArrayList<>();
		for (Integer number : mergedList) {
			if (!finalArrayList.contains(number))
				finalArrayList.add(number);
		}
		makeOneArrayUtil.setResultList(finalArrayList);
		return makeOneArrayUtil;
	}
}
