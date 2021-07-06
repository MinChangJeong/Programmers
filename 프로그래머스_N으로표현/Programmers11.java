package 프로그래머스_N으로표현;

import java.util.*;

public class Programmers11 {
	public int solution(int N, int number) {
        int answer = 1;
        
        List<List<Integer>> result = new ArrayList<>();
        
        Set<Integer> set = new HashSet<Integer>();
        
        String num = String.valueOf(N);
        set.add(N);
        
        while(true) {
        	if(set.contains(number)) {
        		break;
        	}
        	answer+=1;
        	if(answer>8) {
        		answer = -1;
        		break;
        	}
        	List<Integer> list = new ArrayList<>(set);
        	result.add(list);
        	
        	Set<Integer> nums = new HashSet<Integer>();
        	
        	for(int idx= 0; idx<result.size(); idx++) {
        		for(int i : result.get(idx)) {
        			for(int j : result.get(result.size()-idx-1)) {
        				set.add(i+j);
        				if(i-j>0)
        					set.add(i-j);
        				set.add(i*j);
        				if(i/j>0)
        					set.add(i/j);
        			}
        			if(set.contains(number)) {
        				break;
        			}
        		}
        		if(set.contains(number)) {
        			break;
        		}
        	}
        	
        	if(set.contains(number)) {
        		break;
        	}
        	num+=N;
        	Integer k = Integer.parseInt(num);
        	
        	set.add(k);
        	
        }
        return answer;
	}

	public static void main(String [] args) {
		Programmers11 p = new Programmers11();
		p.solution(5, 12);
		p.solution(4, 17);
		p.solution(4, 1936);
		
	}
}
