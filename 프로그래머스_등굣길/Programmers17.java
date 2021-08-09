package 프로그래머스_등굣길;

public class Programmers17 {
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean [][] check = new boolean [n][m];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		check[i][j] = true;
        	}
        }
        
        for(int [] puddle : puddles) {
        	if(puddle.length > 0)
        		check[puddle[1]-1][puddle[0]-1] = false;
        }
        
        answer = bfs(m-1, n-1, 1, 0, check) + bfs(m-1, n-1, 0, 1, check);
        
        System.out.println(answer);
        return answer;
    }

	int bfs(int m, int n, int m_node, int n_node, boolean [][] check) {
		System.out.println("n_node : "+ n_node);
		System.out.println("m_node : "+ m_node);
		System.out.println();
		
		if(n_node == n && m_node == m) {
			return 1;
		}
		else if(n_node == n && m_node < m) {
			if(check[n_node][m_node]) {
				return bfs(m, n, m_node+1, n_node, check);
			}
			else 
				return 0;			
		}
		else  if(n_node < n && m_node == m) {
			if(check[n_node][m_node]) {
				return bfs(m, n, m_node, n_node+1, check);
			}
			else 
				return 0;
		}
		else {
			if(check[n_node][m_node]) {
				return bfs(m, n, m_node+1, n_node, check) + bfs(m, n, m_node, n_node+1, check);
			}
			else 
				return 0;
		}
	}
	
	public static void main(String [] args) {
		Programmers17 p = new Programmers17();
		int [][] puddles = { {2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3} };
		p.solution(7, 4, puddles);
	}
}
