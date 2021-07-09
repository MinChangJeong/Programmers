package 프로그래머스_순위;

public class Programmers13 {
	 public int solution(int n, int[][] results) {
        int answer = 0;
        
        /*
         * win : 1
         * null : 0
         * lose : -1
         * */
        
        int [][] rank = new int[n][n];
        
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		rank[i][j] = 0;
        	}
        }
        
        for(int i=0; i<results.length; i++) {
        	rank[results[i][0]-1][results[i][1]-1] = 1;
        	rank[results[i][1]-1][results[i][0]-1] = -1;
        }
       
        
        /*
         * 1. for => 거쳐가는 노드를 차례차례 변경하기 위함
         * 2. for => i
         * 3. for => j
         * */
        
        for(int node=0; node<rank.length; node++) {
        	for(int i=0; i<rank.length; i++) {
        		for(int j=0; j<rank.length; j++) {
        			if(node != i && node != j && i!=j) {
        				if(rank[i][node]==1 && rank[node][j]==1) {
        					rank[i][j] = 1;
        				}
        				else if(rank[i][node]== -1 && rank[node][j]== -1) {
        					rank[i][j] = -1;
        				}
        			}
        		}
        	}
        }
        
        
        for(int [] node : rank) {
        	int cnt = 0;
        	for(int num : node) {
        		if(num == 0) {
        			cnt+=1;
        		}
        	}
        	if(cnt == 1) {
        		answer+=1;
        	}
        }
        System.out.println(answer);
        
        
        return answer;
	 }
	 
}
