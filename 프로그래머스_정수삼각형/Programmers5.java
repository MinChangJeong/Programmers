package 프로그래머스_정수삼각형;

import java.util.*;

// f(n)(layer, idx) = f(n+1)(layer+1, idx) + f(n+1)(layer+1, idx+1)
// 이코드의 문제 : 동적계획법의 핵심인 caching을 구현하지 못함 , 반복되는 계산이 많음
public class Programmers5 {
	public int solution(int[][] triangle) {
        int answer = 0;
        
        List<Integer> result = new ArrayList<>();
        
        int sum = 0;
        int layer = 0;
        int idx = 0;
     
        dynamic(triangle, result, sum, layer, idx); 
        
        for(int num : result) {
        	if(answer<=num) {
        		answer = num;
        	}
        }
        return answer;
	}
	
	List<Integer> dynamic(int[][] triangle, List<Integer> result, int sum, int layer, int idx) {
		if(layer == triangle.length-1) {
			sum = sum+triangle[layer][idx];
			result.add(sum);
			System.out.println(result);
			return result;
		}
		
		dynamic(triangle, result, sum+triangle[layer][idx], ++layer, idx);
		dynamic(triangle, result, sum+triangle[layer][idx], layer++, idx+=1);
		
		return result;
	}

	public static void main(String[] args) {
		Programmers5 p = new Programmers5();
		int [][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(p.solution(triangle));
	}
}
