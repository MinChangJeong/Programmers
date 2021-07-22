package 프로그래머스_섬연결하기;

import java.util.*;

// 테케는 전부 통과하지만 이방식이 아닌듯 하다 
// 크루스칼 알고리즘에 대한 공부가 필요해 보인다!
public class Programmers15 {
	public int solution(int n, int[][] costs) {
        int answer = 0;
       
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<costs.length; i++) {
        	System.out.println(costs[i][0] + " , "+costs[i][1]+ " : "+costs[i][2]);	
        	if(map.size()<n-1) {
        		if((map.get(costs[i][0]) == null && map.get(costs[i][1]) == null )) {
            		map.put(costs[i][0], costs[i][1]);
            		answer+=costs[i][2];
            	}
            	else if(map.get(costs[i][0]) != null && map.get(costs[i][1]) == null) {
            		if(map.get(map.get(costs[i][0])) == null || map.get(map.get(costs[i][0])) != costs[i][1]) {
                		map.put(costs[i][1], costs[i][0]);
                		answer+=costs[i][2];            			
            		}
            	}
            	else if(map.get(costs[i][0]) == null && map.get(costs[i][1]) != null) {
            		if(map.get(map.get(costs[i][1])) == null || map.get(map.get(costs[i][1])) != costs[i][0] ) {
                		map.put(costs[i][0], costs[i][1]);
                		answer+=costs[i][2];	
            		}
            	}
        	}
        	System.out.println(map);
        }
        
        System.out.println(answer);
        return answer;
    }
	
	public static void main(String [] args) {

		Programmers15 p = new Programmers15();
		int [][] costs = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};
		int [][] costs2 =  {{0, 1, 1}, {3, 4, 1}, {1, 2, 2}, {2, 3, 4}};
		int [][] costs3 = {{0, 1, 1}, {3, 1, 1}, {0, 2, 2}, {0, 3, 2}, {0, 4, 100}};
		int [][] costs4 = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}};
		int [][] costs5 = {{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {1, 3, 2}, {0, 3, 4}};
		p.solution(6, costs);
		System.out.println();
		p.solution(5, costs2);
		System.out.println();
		p.solution(5, costs3);
		System.out.println();
		p.solution(5, costs4);
		System.out.println();
		p.solution(4, costs5);
	}
}
