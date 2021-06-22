package 프로그래머스_가장먼노드;

import java.util.*;

public class Programmers3 {
	public int solution(int n, int[][] edge) {

		boolean [] visited = new boolean[n];
		
		Queue<Integer> nodes = new LinkedList<>();
		nodes.add(1);
		
		int [] distance = new int[n];
		
		int[] dunode = new int[n];
		dunode[0] = 0;
		
		bfs(edge, visited, nodes, distance, dunode);
		
		int max = 0;
		for(int d : distance) {
			if(max<= d) {
				max = d;
			}
		}
		int sum = 0;
		for(int d : distance) {
			if(d == max) {
				sum+=1;
			}
		}
		return sum;
	}
	
	int [] bfs(int [][] edge, boolean[] visited, Queue<Integer> nodes, int [] distance, int[] dunode) {

		if(nodes.isEmpty()) {
			return distance;
		}
		
		int node = nodes.poll();
		
		for(int i=0; i<edge.length; i++) {
			if(edge[i][0] == node && !visited[edge[i][1]-1]) {
				nodes.add(edge[i][1]);				
				visited[edge[i][1]-1] = true;
				if(dunode[edge[i][1]-1] == 0) {
					dunode[edge[i][1]-1] = node;
				}
				if(distance[edge[i][1]-1] == 0) {
					distance[edge[i][1]-1] = distance[dunode[edge[i][1]-1]-1] +1;
				}
			}
			else if(edge[i][1] == node && !visited[edge[i][0]-1]) {
				nodes.add(edge[i][0]);
				visited[edge[i][0]-1] = true;
				if(dunode[edge[i][0]-1] == 0) {
					dunode[edge[i][0]-1] = node;
				}
				if(distance[edge[i][0]-1] == 0) {
					distance[edge[i][0]-1] = distance[dunode[edge[i][0]-1]-1] +1;
				}
			}
		}
		visited[node-1] = true;

		if(!nodes.isEmpty()) {
			bfs(edge, visited, nodes, distance, dunode);
		}
		
		return distance;
	}
	
}
