package com.tavant.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapMain {
	public static void main(String[] args) {
		TreeMap< Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(1200, "Virendra");
		
		map.put(122, "Ekta");
		map.put(100, "Aditi");
		
		
		
		System.out.println(map);
		System.out.println(map.descendingMap());
		System.out.println(map.descendingKeySet());
		System.out.println(map.lowerEntry(102));
		System.out.println(map.higherEntry(102));
	}
}
