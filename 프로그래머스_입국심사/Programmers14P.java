package 프로그래머스_입국심사;

import java.util.Arrays;

public class Programmers14P {
	public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1]*n;
        long mid = 0;
        
        long sum;
        long answer = right;
        while(left<=right) {
        	sum = 0;
        	mid = (left+right)/2;
        	for(int time : times) {
        		sum+= mid/time;
        	}
        	if(sum>=n) {
        		if(mid<answer) {
        			answer = mid;
        		}
        		right = mid-1;
        	}
        	else {
        		left = mid+1;
        	};
        }
        
        System.out.println("answer : " + answer);
        return answer;
    }
}
