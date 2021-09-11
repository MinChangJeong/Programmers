package Kakao;

import java.util.*;

public class Kakao1 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, List<String>> result = new HashMap<String, List<String>>();
        
        Map<String, Integer> stopped = new HashMap<String, Integer>();
        
        
        for(int i=0; i<report.length; i++) {
        	String [] report_list = report[i].split(" ");
        	
        	String reporter = report_list[0];
        	String repored = report_list[1];
        	
        	if(result.containsKey(reporter)) {
        		if(!result.get(reporter).contains(repored)) {
            		List<String> list = result.get(reporter);
            		list.add(repored);
            		result.put(reporter, list);
        		}
        	}
        	else {
        		List<String> list = new ArrayList<String>();
        		list.add(repored);
        		result.put(reporter, list);
        	}
        	
        }
        
        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
        	for(int i=0; i<entry.getValue().size(); i++) {
        		int cnt = stopped.getOrDefault(entry.getValue().get(i), 0);
        		stopped.put(entry.getValue().get(i), cnt+=1);
        	}
        }
        
        Map<String, Boolean> check = new HashMap<String, Boolean>();

        Map<String, Integer> final_result = new LinkedHashMap<String, Integer>();
        
        for(int i=0; i<id_list.length; i++) {
        	check.put(id_list[i], false);
        	final_result.put(id_list[i], 0);
        }
        
        for (Map.Entry<String, Integer> entry : stopped.entrySet()) {
        	if(entry.getValue() >= k) {
        		check.put(entry.getKey(), true);
        	}
        }

        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
        	
        	for(int i=0; i<entry.getValue().size(); i++) {
        		if(check.get(entry.getValue().get(i))) {
        			int cnt = final_result.getOrDefault(entry.getKey(), 0);
        			final_result.put(entry.getKey(), cnt+=1);
        		}
        	}
        }
        
        System.out.println(final_result);
        
        int idx = 0;
        for (Map.Entry<String, Integer> entry : final_result.entrySet()) {
        	answer[idx++] = entry.getValue();
        }
        
        return answer;
    }
	public static void main(String [] args) {
		Kakao1 kakao = new Kakao1();
		String [] id_list = {"muzi", "frodo", "apeach", "neo"};
		String [] report = {"muzi frodo","muzi frodo","muzi frodo","muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		kakao.solution(id_list, report, k);
	}
}
