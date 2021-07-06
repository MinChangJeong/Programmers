package 프로그래머스_디스크컨트롤러;

import java.util.*;

public class Programmers10 {
	public void solution(int[][] jobs) {
        int answer = 0;
        
//        1. 원본 배열 오름차순 정렬
//        	Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
//        2. 1번 확장 버전
//	        Arrays.sort(jobs, (o1, o2) -> {
//	        	if(o1[0] == o2[0]) {
//	        		return Integer.compare(o1[1], o2[1]);
//	        	}
//	        	else {
//	        		return Integer.compare(o1[0], o2[0]);
//	        	}
//	        });

        // 원본 배열 오름차순 정렬 (요청시간 오름차순)
 		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

 		// 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
 		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        for(int i = 0; i<jobs.length; i++) {
        	System.out.println("test : " + jobs[i][0]+" : "+jobs[i][1]);
        	
        }
        
        int cnt = 0;
        int time = 0;
        
        
    }
	
	public static void main(String [] args) {
		Programmers10 p = new Programmers10();
		int [][] jobs = {{0,3},{4,4},{5,3},{4,1}};
		p.solution(jobs);
		
//      int a = 10;
//      int b =20;
//      Integer.compare(a,b) => 1. a>b return 1, 2. a<b return -1, 3. a==b return 0
//      System.out.println(Integer.compare(a, b));
//      System.out.println(Integer.compare(b,a));
	}
}
