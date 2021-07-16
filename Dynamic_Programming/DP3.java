package Dynamic_Programming;

// Table
public class DP3 {
	public static void main(String [] args) {
		int answer=0;
		
		int n = 100;
		int node = 10;
		int	[] dp = new int[n-1];
		
		
		answer = dynamic(answer, node, n, dp);
		System.out.println(answer);
		
	}
	
	// 완전 탐색이 되어버림..
	static int dynamic(int answer, int node, int n, int [] dp) {
		if(n == 0) {
			answer +=1;
			return answer;
		}
		if(n == 1) {
			return answer;
		}
		
		for(int i=node; i>=2; i--) {
			if(n<i) {
				continue;
			}
			answer=dynamic(answer, i, n-i, dp);

		}
		
		return answer;
	}
	
	// 동적계획법으로 다시 풀자
	static int dynamicP() {
		
	}
}

