package 프로그래머스_여행경로;

import java.util.*;

public class Programmers12 {
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        Set<String> set = new HashSet<String>();
        
        for(int i=0; i<tickets.length; i++) {
        	if(set.size() == tickets.length+1) {
        		break;
        	}
        	for(int j=0; j<2; j++) {
        		set.add(tickets[i][j]);
        	}
        }
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> store = new HashMap<String, Integer>();
        
        for(String ticket : set) {
        	int cnt = 0;
        	for(int i=0; i<tickets.length; i++) {
        		if(ticket.equals(tickets[i][0])) {
        			cnt+=1;
        		}
        	}
        	map.put(ticket, cnt);
        	store.put(ticket, 0);
        }
        
        boolean [] check = new boolean[tickets.length];
        
        // check , answer, node(현재위치), idx(answer의 인덱스값), tickets, 
        int idx = 0;
        answer[idx] = "ICN";
        String node = answer[idx];
        store.put(node, store.get(node)+1);
        idx+=1;
        
        dfs(check, answer, node, idx, tickets, map, store);
        
        return answer;
    }
    
    String [] dfs(boolean [] check, String [] answer, String node, int idx, String [][] tickets, Map<String, Integer> map, Map<String, Integer> store) {
    	// 다음 티켓으로 가능한 경우를 list에 저장, list는 항상 초기화
    	List<String> list = new ArrayList<String>();
    	
    	int k= 0;
    	for(int i=0; i<tickets.length; i++) {
    		if(tickets[i][0].equals(node) && !check[i]) {
    			if(list.isEmpty()) {
    				k = i;
    			}
    			if(!list.isEmpty() && tickets[i][1].compareTo(list.get(list.size()-1)) < 0 && store.get(tickets[i][1])!=map.get(tickets[i][1]) ) {
    				k = i;
    			}
    			list.add(tickets[i][1]);
    		}
    	}
    	// 알파벳 순으로 정렬
    	Collections.sort(list);
    	// 알파벳 순으로 정렬 했을때 가장 먼저 오는 값을 다음 티켓으로 사용
    	check[k] = true;
    	
    	if(idx == answer.length-1) {
    		answer[idx] = list.get(0);
    		return answer;
    	}
    	int cnt = 0;

    	while(true) {
    		if(store.get(list.get(cnt)) != map.get(list.get(cnt))) {
    			break;
    		}
    		cnt++;
    	}
    	node = list.get(cnt);
    	
    	// 해당 airport에서 ticket을 몇번 사용했는지 체크!
    	store.put(node, store.get(node)+1);
    	answer[idx] = node;
    	
    	idx+=1;

    	dfs(check, answer, node, idx, tickets, map, store);
    	
    	return answer;
    }
    
    public static void main(String [] args) {
    	Programmers12 p = new Programmers12();
    	String [][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
    	String [][] tickets2 = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
    	p.solution(tickets);
    	System.out.println("__________");
    	p.solution(tickets2);
    }
}
