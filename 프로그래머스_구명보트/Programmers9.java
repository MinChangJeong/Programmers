package ���α׷��ӽ�_����Ʈ;

// �ð��ʰ� ������ ��..
// Greedy������� Ǫ�°� ������ ���� ���!!
public class Programmers9 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        boolean [] check = new boolean[people.length];
        
        int idx = 0;
        int t_idx = 0;
        
        for(int i=0; i<people.length; i++) {
        	int sum=0;
        	for(int j=0; j<people.length; j++) {
        		if(i!=j && !check[i] && !check[j] && people[i]+people[j]<=limit) {
        			if(sum < people[i]+people[j]) {
        				sum = people[i] + people[j];
        				idx = i;
        				t_idx = j;
        			}
        		}
        	}
        	if(idx!=t_idx) {
            	check[idx] = true;
            	check[t_idx] = true;
        	}
        	answer+=1;
        }
        int sum = 0;
        for(boolean c : check) {
        	if(c)
        		sum+=1;
        }
        answer-=sum/2;
        return answer;
    }
	
}
