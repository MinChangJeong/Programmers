package weekly_challenge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Challenge4 {
	public String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
	 
		String [][] info = new String[table.length][1];
		
		for(int i=0; i<table.length; i++) {
			info[i] = table[i].split(" ");
		}
		
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String, Integer>>();
		
		for(int i=0; i<info.length; i++) {
			Map<String, Integer> linkedMap= new LinkedHashMap<String, Integer>();
			for(int j=5; j>=0; j--) {
				if(j==0) {
					map.put(info[i][j], linkedMap);
				}
				else {
					linkedMap.put(info[i][j], 5-j+1);	
				}
				
			}
		}
		
		Map<String, Integer> result = new TreeMap<String, Integer>();
		
		int max = 0;
		
		for(String key : map.keySet()) {
			int sum = 0;
			for(int j=0; j<languages.length; j++) {
				if(map.get(key).containsKey(languages[j])) {
					sum+=map.get(key).get(languages[j])*preference[j];
				}
			}
			result.put(key, sum);
			if(max <sum) {
				max = sum;
			}
		}
		
		for(String key : result.keySet()) {
			if(result.get(key) == max) {
				answer = key;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String [] args) {
		Challenge4 c = new Challenge4();
		String [] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String [] languages = {"PYTHON", "C++", "SQL"};
		int [] preference = {7,5,5};
		
		c.solution(table, languages, preference);
	}
}