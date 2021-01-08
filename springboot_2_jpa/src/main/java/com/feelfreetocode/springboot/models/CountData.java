package com.feelfreetocode.springboot.models;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;


public interface CountData {
	public String getCode();
	public Long getCount();
	public default HashMap<String, Long> getMap(){
		HashMap< String, Long> hashMap = new HashMap<>();
		hashMap.put(getCode(), getCount());
		return hashMap;
	}
}
