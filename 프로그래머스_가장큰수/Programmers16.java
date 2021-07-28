package 프로그래머스_가장큰수;

import java.util.*;

public class Programmers16 {
	public static int[] sort(int[] arr) {
		System.out.println("arr.length: "+arr.length);
        if (arr.length < 2) return arr;

        int mid = arr.length / 2;
        int[] low_arr = sort(Arrays.copyOfRange(arr, 0, mid));
        int[] high_arr = sort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] mergedArr = new int[arr.length];
        int m = 0, l = 0, h = 0;
        while (l < low_arr.length && h < high_arr.length) {
        	String first = Integer.toString(low_arr[l])+Integer.toString(high_arr[h]);
        	String second = Integer.toString(high_arr[h])+Integer.toString(low_arr[l]);
        	
        	int numF = Integer.parseInt(first);
        	int numS = Integer.parseInt(second);
        	
            if (numF > numS)
                mergedArr[m++] = low_arr[l++];
            else
                mergedArr[m++] = high_arr[h++];
        }
        while (l < low_arr.length) {
            mergedArr[m++] = low_arr[l++];
        }
        while (h < high_arr.length) {
            mergedArr[m++] = high_arr[h++];
        }
        System.out.println(mergedArr.length);
        return mergedArr;
    }
    public String solution(int[] numbers) {
       String answer = "";
    	
    	boolean check = false;
        for(int n : numbers) {
        	if(n!=0)
        		check=true;
        }
        if(check==false) {
        	return "0";
        }
    	numbers = sort(numbers);
    	
    	for(int n : numbers) {
    		answer+=n;
    	}
    	System.out.println(answer);
    	return answer;
    }
    
    public static void main(String [] args) {
    	Programmers16 p = new Programmers16();
    	p.solution(new  int [] {1000, 0, 5, 99, 100});
    }
}
