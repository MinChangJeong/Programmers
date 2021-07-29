package 프로그래머스_여행경로;

import java.util.*;

public class Programmers12P {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        Arrays.sort(tickets, new Comparator<String[]>() {
			
        public int compare(String[] o1, String[] o2) {
            if(o1[0].toString().contentEquals(o2[0].toString()))
                return o1[1].toString().compareTo(o2[1].toString());
            else
                return o1[0].toString().compareTo(o2[0].toString());
        	}			
    	});
        
        
        
        
        return answer;
    }

       
    public static void main(String [] args) {
    	Programmers12P p = new Programmers12P();
    	String [][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
    	p.solution(tickets);
    	
    }
}

