package 프로그래머스_여행경로;

import java.util.*;

public class Programmers12P {
    public String[] solution(String[][] tickets) {    
        Arrays.sort(tickets, new Comparator<String[]>() {
			
        public int compare(String[] o1, String[] o2) {
            if(o1[0].toString().contentEquals(o2[0].toString()))
                return o1[1].toString().compareTo(o2[1].toString());
            else
                return o1[0].toString().compareTo(o2[0].toString());
        	}			
    	});
    
        Stack<String> stack = new Stack<String>();
        stack.add("ICN");
        
        List<String> result = new ArrayList<String>();
        
        boolean [] check = new boolean[tickets.length];
        
        dfs(tickets, stack, result, check);
        
        String[] answer = new String[result.size()];
        
        
        for(int idx=result.size()-1; idx>=0; idx--) {
        	answer[answer.length-idx-1] = result.get(idx);
        }
        
        return answer;
    }
    
    void dfs(String[][] tickets, Stack<String> stack, List<String> result, boolean [] check) {
    	if(stack.size()!=0) {
    		boolean stack_change_check = false;
    		for(int idx=0; idx<tickets.length; idx++) {
    			if(!check[idx] && tickets[idx][0].equals(stack.peek())) {
    				stack.add(tickets[idx][1]);
    				check[idx] = true;
    				stack_change_check = true;
    				dfs(tickets, stack, result, check);
    			}
    		}
    		if(!stack_change_check) {
    			result.add(stack.pop());
    			dfs(tickets, stack, result, check);
    		}
    		
    	}
    }

       
    public static void main(String [] args) {
    	Programmers12P p = new Programmers12P();
    	String [][] tickets = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
    	p.solution(tickets);
    	
    }
}

