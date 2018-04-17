package br.ufrn.imd.master.getbehavior.utils;

import java.util.HashMap;
import java.util.Map;

public class StringWorker {

	public static HashMap<String,String> ReadingFromHashString(String hash) {
		
		String hashNew = new String();
		hashNew = hash.replace("\"", "");
		hashNew = hashNew.replace("{", "");
		hashNew = hashNew.replace("}", "");
		hashNew = hashNew.replace("\\", "");
		
		Map<String, String> myMap = new HashMap<String, String>();
		String[] pairs = hashNew.split(",");
		
		for (int i=0;i<pairs.length;i++) {
		    String pair = pairs[i];
		    String[] keyValue = pair.split(":");
		    myMap.put(keyValue[0], String.valueOf(keyValue[1]));
		}
		
		return (HashMap<String, String>) myMap;
	}
	
}