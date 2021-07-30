package 프로그래머스_베스트앨범;

import java.util.*;

public class Programmers8P {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for(int i=0; i<genres.length; i++) {
        	if(map.get(genres[i]) != null) {
        		List<Integer> list = map.get(genres[i]);
        		list.add(i);
        		map.put(genres[i], list);
        	}
        	else {
        		List<Integer> list = new ArrayList<Integer>();
        		list.add(i);
        		map.put(genres[i], list);
        	}
        }
        
        Map<String, Integer> sum = new HashMap<String, Integer>();
        Map<String, Integer> max = new HashMap<String, Integer>();
       
        
        for(int i=0; i<genres.length; i++)	 {
        	if(sum.get(genres[i]) != null) {
        		sum.put(genres[i], sum.get(genres[i])+plays[i]);
        	}
        	else {
        		sum.put(genres[i], plays[i]);
        	}
        	if(max.get(genres[i]) != null) {
        		if(plays[max.get(genres[i])] < plays[i]) {
        			max.put(genres[i], i);
        		}
        	}
        	else {
        		max.put(genres[i], i);
        	}
        }
         
        List<String> keyset = new ArrayList<>(sum.keySet());
        
        Collections.sort(keyset, (o1, o2) -> (sum.get(o2).compareTo(sum.get(o1))));
       
        
        List<Integer> result = new ArrayList<Integer>();
             
        for(String genre : keyset) {
        	result.add(max.get(genre));
        	int second_max_num = 0;
        	int idx = 0;
        	for(int play : map.get(genre)) {
        		if(plays[play] > second_max_num && play != max.get(genre)) {
        			second_max_num = plays[play];
        			idx = play;
        		}
        	}
        	if(second_max_num !=0 ) {
        		result.add(idx);
        	}
        	
        }
        
        
        int [] answer = new int [result.size()];
        
        for(int idx=0; idx<result.size(); idx++) {
        	answer[idx] = result.get(idx);
        }
      
        return answer;
    }
	
}
