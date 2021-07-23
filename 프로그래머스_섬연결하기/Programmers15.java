package 프로그래머스_섬연결하기;

import java.util.*;

public class Programmers15 {
	public int solution(int n, int[][] costs) {
        int answer = 0;
       
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int [] parent = new int[n];
        
        for(int i=0; i<parent.length; i++	) {
        	parent[i] = i;
        }
     
        for(int i=0; i<costs.length; i++) {
        	int cost1 = getParent(parent, costs[i][0]);
        	int cost2 = getParent(parent, costs[i][1]);
        	
        	if(cost1 > cost2) {
        		parent[costs[i][0]] = cost2;
            	for(int j=0; j<n; j++) {
            		if(parent[j] == cost1) {
            			parent[j] = cost2;
            		}
            	}
            	answer+=costs[i][2];
        	}
        	else if(cost2 > cost1) {
        		parent[costs[i][1]] = cost1;
            	for(int j=0; j<n; j++) {
            		if(parent[j] == cost2) {
            			parent[j] = cost1;
            		}
            	}
            	answer+=costs[i][2];
        	}
       	
        }
        return answer;
	}
	
	int getParent(int parent[], int num) {
		if(parent[num] == num) return num;
		return parent[num] = getParent(parent, parent[num]);
	}
	

	
}
