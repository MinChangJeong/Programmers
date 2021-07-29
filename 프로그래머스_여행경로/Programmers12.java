package ���α׷��ӽ�_������;

import java.util.*;

public class Programmers12 {
	public String[] solution(String[][] tickets) {
		String [] answer = new String[tickets.length+1];
		
		boolean [] check = new boolean[tickets.length];
		int [] check_idx = new int [tickets.length];
		
		int idx = 0;
		answer[idx] = "ICN";
		String node = answer[idx];
		idx +=1;
		
		int cnt = 0;
		boolean renew = false;
		dfs(check, answer, node, idx, tickets, cnt, check_idx, renew);
		
		for(String a : answer) {
			System.out.println(a);
		}
		return answer;
		
	}
	
	String [] dfs(boolean [] check, String[] answer, String node, int idx, String[][] tickets, int cnt, int [] check_idx, boolean renew) {
		List<String> list = new ArrayList<String>();
		
		int k = 0;
    	for(int i=0; i<tickets.length; i++) {
    		if(tickets[i][0].equals(node) && !check[i]) {
    			if(list.isEmpty()) {
    				k = i;
    			}
    			if(!list.isEmpty() && tickets[i][1].compareTo(list.get(list.size()-1)) < 0) {
    				k = i;
    			}
    			list.add(tickets[i][1]);
    		}
    	}

    	Collections.sort(list);
    	
    	
    	// list is empty : k always 0, ���� ���� �ǵ����� cnt+=1 �׸��� ���� ��忡�� check���� false�� �ٽ� �ٲ��ش�. 
    	// list is not empty : k is sort ������ ���� ù��° idx
    	
    	// list.size() == cnt : ���� ���� �ǵ�����. cnt�� �״�� �ΰ�
    	
    	// check_idx : 0~check_idx.length-1 ���� �ش� ��� Ƽ���� idx
    	
    	// node : start airport
    	
    	// cnt : �׻� 0��° ���� �ҷ������� 0��°�� �ҷ������� ���� ��� ���� ������ cnt+=1�� �Ѵ�.
    	
    	
    	if(idx == answer.length-1) {
    		answer[idx] = list.get(0);
    		return answer;
    	}
    	
    	if(list.isEmpty()) {

    		
    		node = answer[idx-=2];    	
    		
    		for(int ci=0; ci<check_idx.length; ci++) {
    			if(check_idx[ci] == 0 && ci!=0) {
    				check[check_idx[ci-1]] = false;
    				check_idx[ci-1] = 0;
    				break;
    			}
    		}
    		
    		cnt +=1;
    		idx+=1;
    		renew = true;
    		return dfs(check, answer, node, idx, tickets, cnt, check_idx, renew);
    	}
    	
    	if(list.size() == cnt) {
    		node = answer[idx-=2];
    		System.out.println(node);
    		for(int ci=0; ci<check_idx.length; ci++) {
    			if(check_idx[ci] == 0 && ci!=0) {
    				check[check_idx[ci-1]] = false;
    				check_idx[ci-1] = 0;
    				break;
    			}
    		}
    		idx+=1;

    		return dfs(check, answer, node, idx, tickets, cnt, check_idx, renew);
    	}
    	
    	String back_node = node;
    	node = list.get(cnt);
    	answer[idx] = node;
    	if(renew) {
    		for(int i=0; i<tickets.length; i++) {
    			if(tickets[i][0].equals(back_node) && tickets[i][1].equals(node)) {
					k = i;
					renew = false;
					break;
				}
    		}
    	}
    	// 1�� test �̺κп��� ��Ÿ�� ������ ���µ�?
    	check_idx[idx-1] = k;
    	check[check_idx[idx-1]] = true;
    	idx+=1;
    	cnt = 0;
    	
    	
    	dfs(check, answer, node, idx, tickets, cnt, check_idx, renew);
    	
    	return answer;
    	
	}
    
    public static void main(String [] args) {
    	Programmers12 p = new Programmers12();
    	String [][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};
    	p.solution(tickets);
    }
}
