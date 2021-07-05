package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		
		int answer = 0;
		int start = findNum(N);
		
		List<Integer> nums = new ArrayList<Integer>();
		int [] dp = new int [N+1];
		
		while(start>=1) {
			nums.add(start);
			start = start/2;
		} 
		Collections.sort(nums);
		
		dp[0] = 1;
		for(int num : nums) {
			for(int i = num; i<=N; i++) {
				dp[i] += dp[i-num];
			}
		}
		System.out.println(dp[N]);
	}
	
	static int findNum(int N) {
		int cnt = 1;
		while(true) {
			if(N<cnt) {
				return cnt/2;
			}
			cnt*=2;
		}
		
	}
}
