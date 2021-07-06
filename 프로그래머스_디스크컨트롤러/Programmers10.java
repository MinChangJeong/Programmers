package ���α׷��ӽ�_��ũ��Ʈ�ѷ�;

import java.util.*;

public class Programmers10 {
	public void solution(int[][] jobs) {
        int answer = 0;
        
//        1. ���� �迭 �������� ����
//        	Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
//        2. 1�� Ȯ�� ����
//	        Arrays.sort(jobs, (o1, o2) -> {
//	        	if(o1[0] == o2[0]) {
//	        		return Integer.compare(o1[1], o2[1]);
//	        	}
//	        	else {
//	        		return Integer.compare(o1[0], o2[0]);
//	        	}
//	        });

        // ���� �迭 �������� ���� (��û�ð� ��������)
 		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

 		// ó�� �ð� ������������ ���ĵǴ� �켱���� ť(Heap)
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
