package weekly_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Challenge2 {
	public String solution(int[][] scores) {
        String answer = "";
        
        List<List<Integer>> person = new ArrayList<List<Integer>>();
        
        for(int i=0; i<scores.length; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int t_idx = 0;
            while(list.size() != scores.length) {
                list.add(scores[t_idx][i]);
                t_idx+=1;
            }
            person.add(list);
        }

        int [] max = new int [scores.length];
        int [] min = new int [scores.length];
        
        for(int i=0; i<person.size(); i++) {
        	max[i] = Collections.max(person.get(i));
        	min[i] = Collections.min(person.get(i));
        }
        
        boolean [] check = new boolean [scores.length];
        
        
        for(int i=0; i<person.size(); i++) {
        	for(int j=0; j<person.size(); j++) {
        		if(i == j) {
        			if(person.get(i).get(j) == max[i]) {
        				int cnt = 0;
        				for(int k=0; k<person.size(); k++) {
        					if(max[i] == person.get(i).get(k)) {
        						cnt+=1;
        					}
        				}
        				if(cnt == 1) {
        					check[i] = true;
        				}
        			}
        			else if(person.get(i).get(j) == min[i]) {
        				int cnt = 0;
        				for(int k=0; k<person.size(); k++) {
        					if(min[i] == person.get(i).get(k)) {
        						cnt+=1;
        					}
        				}
        				if(cnt == 1) {
        					check[i] = true;
        				}
        			}
        		}
        	}
        }
        
        
        for(int i=0; i<person.size(); i++) {
        	int sum = 0;
        	int cnt = 0;
        	for(int j=0; j<person.size(); j++) {
        		if(i == j) {
        			if(!check[i]) {
        				sum+=person.get(i).get(j);
        				cnt+=1;
        			}
        		}
        		else {
        			sum+=person.get(i).get(j);
            		cnt+=1;
        		}
        	}
        	int average = sum/cnt;
        	
        	if(average>=90) {
        		answer+="A";
        	}
        	else if(average<90 && average>=80) {
        		answer+="B";
        	}
        	else if(average<80 && average>=70) {
        		answer+="C";
        	}
        	else if(average<70 && average>=50) {
        		answer+="D";
        	}
        	else {
        		answer+="F";
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
