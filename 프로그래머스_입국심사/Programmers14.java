package 프로그래머스_입국심사;

import java.util.Arrays;

// 이분 탐색의 문제는 클틀에서 문제를 보는게 중요한것 같다, 문제에서 구하고자하는 결과 자체를 범위를 두고 이분탐색으로 결과값을 찾는 접근을 시도해보자
public class Programmers14 {
	public long solution(int n, int[] times) {
        long answer = 1000000000;
		
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1]*n;
        long mid = (left+right)/2;
        
        long sum;
		
        while(left<=right) {
        	sum = 0;
        	for(int time : times) {
        		sum+=mid/time;
        	}
        	if(sum>=n) {
            	if(answer>= mid) {
            		answer = mid;
            	}
        		right = mid-1;
        	}
        	else {
        		left = mid+1;
        	}
        	mid = (left+right)/2;
        }
        
        System.out.println("answer : " + answer);
        return answer;
    }
	
	
	
	public static void main(String [] args) {
		Programmers14 p = new Programmers14();
		int [] times = {7,10};
		int [] times2 = {2,5};
		int [] times3 = {1, 99, 99};
		int [] times4 = {2,2,2,2,2,2};
		p.solution(6, times);
		p.solution(2, times2);
		p.solution(98, times3);
		p.solution(8, times4);

	}
}
