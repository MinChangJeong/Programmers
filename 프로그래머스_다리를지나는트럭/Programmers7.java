package 프로그래머스_다리를지나는트럭;

import java.util.*;

public class Programmers7 {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        int sum = 0;
        int idx = 0;
        
        while(true) {
        	if(idx == truck_weights.length && queue.isEmpty()) {
        		break;
        	}
        	if(queue.size() == bridge_length) {
        		sum = sum - queue.poll();
        	}
        	if(idx != truck_weights.length &&  sum + truck_weights[idx] <= weight) {
        		queue.add(truck_weights[idx]);
        		sum = sum + truck_weights[idx];
        		idx+=1;
        	}
        	else {
        		queue.add(0);
        	}
        	System.out.println(queue);
        	answer +=1;
        	int summary = 0;
        	for(int q : queue) {
        		summary+=q;
        	}
        	if(summary == 0) {
        		break;
        	}
        }
        return answer;
    }
	
	public static void main(String [] args) {
		Programmers7 p = new Programmers7();
		int [] truck_weights = {7,4,5,6};
		p.solution(2, 10, truck_weights);
	}
}
