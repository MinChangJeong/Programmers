package 프로그래머스_단어변환;

import java.util.*;

public class Programmers2 {
	public int solution(String begin, String target, String[] words) {
		boolean available = false;
		for(String word : words) {
			if(word.equals(target)) {
				available = true;
			}
		}
		if(!available)
			return 0;
		
		List<Integer> result = new ArrayList<>();
		boolean [] visited = new boolean[words.length];
		
		Queue<String> nodes = new LinkedList<>();
		for(int idx = 0; idx<words.length; idx++) {
			if(checkNode(begin, words[idx])) {
				nodes.add(words[idx]);
			}
		}
		int cnt = 0;
		for(String node : nodes) {
			cnt+=1;
			dfs(node, target, words, nodes, visited, cnt, result);
		}
		
		result.sort(null);
		
		return result.get(0);
     }
	
	List<Integer> dfs(String node, String target, String [] words, 
				Queue<String> nodes, boolean[] visited, int cnt, List<Integer> result) {
		for(String n : nodes) {
			if(n.equals(target)) {
				result.add(cnt);
				return result;
			}
		}
		
		Queue<String> queue = new LinkedList<>();
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(node)) {
				visited[i] = true;
			}
			
			if(!node.equals(words[i]) && checkNode(node, words[i]) && !visited[i]) {
				queue.add(words[i]);
			}
		}
		for(String q : queue) {
			cnt+=1;
			dfs(q, target, words, queue, visited, cnt, result);
		}
		return result;
	}
	
	boolean checkNode(String f_word, String s_word) {
		String [] f_words = f_word.split("");
		String [] s_words = s_word.split("");
		
		int cnt = 0;
		for(int i=0; i<f_words.length; i++) {
			if(f_words[i].equals(s_words[i])) 
				cnt++;
		}
		
		if(cnt == f_words.length-1) {
			return true;
		}			
		return false;
	}


}


