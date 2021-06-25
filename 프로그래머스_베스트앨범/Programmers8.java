package 프로그래머스_베스트앨범;

import java.util.*;

public class Programmers8 {
	public int[] solution(String[] genres, int[] plays) {
	
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		Map<String, List<Integer>> lists = new HashMap<String, List<Integer>>();
		
		for(int i=0; i<plays.length; i++) {
			map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
			
			if(lists.get(genres[i]) == null) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				lists.put(genres[i], list);
			}
			else {
				lists.get(genres[i]).add(i);
			}
		}
		
		int idx = 0;
		int [] totals = new int[map.size()];
		for(int total : map.values()) {
			totals[idx] = total;
			idx+=1;
		}
		
		Arrays.sort(totals);
		
		Map <Integer, String> result = new HashMap<Integer, String>();
		String [] gen = new String[map.size()];
        int [] pla = new int[map.size()];

        int id=0;
        for(int t : map.values()) {
        	pla[id] = t;
        	id+=1;
        }
        id=0;
        for(String g : map.keySet()) {
        	gen[id] = g;
        	id+=1;
        }
        for(int i=0; i<gen.length; i++) {
        	result.put(pla[i], gen[i]);
        }
		
        List<Integer> answer = new ArrayList<>();
        for(int i=totals.length-1; i>=0; i--) {
        	Queue<Integer> queue = new LinkedList<>();
        	 
        	String genre = result.get(totals[i]);
        	
        	compareResult(queue, lists.get(genre), plays);
        	for(int j : queue) {
        		answer.add(j);
        	}
        }
        
        int [] conclusion = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
        	conclusion[i] = answer.get(i);
        }
        return conclusion;
	}
	void compareResult(Queue<Integer> queue, List<Integer> list, int [] plays) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		
		for(int i : list) {
			if(map.get(plays[i]) == null) {
				List<Integer> nums = new ArrayList<Integer>();
				nums.add(i);
				map.put(plays[i], nums);
				continue;
			}
			map.get(plays[i]).add(i);
		}
		int [] nums = new int[map.size()];
		
		int idx = 0;
		for(int i : map.keySet()) {
			nums[idx] = i;
			idx+=1;
		}
		
		Arrays.sort(nums);
		
		idx=nums.length-1;
		while(queue.size() != 2) {
			for(int i : map.get(nums[idx])) {
				if(queue.size() !=2) {
					queue.add(i);
				}
			}
			idx-=1;
		}
	}
	
	
	public static void main(String [] args) {
		Programmers8 p = new Programmers8();
		String [] genres = {"classic", "pop", "classic", "classic", "pop"};
		int [] plays = {500, 2500, 150, 800, 2500};
		p.solution(genres, plays);
	}
}
