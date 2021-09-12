package Kakao;

public class Kakao2 {
	public int solution(int n, int k) {
        int answer = 0;
        
        String ans = "";
        while(n>0) {
        	ans = (n%k) + ans;
        	n/=k;
        }
        
        String [] result = ans.split("0");
        
        for(int i=0; i<result.length; i++ ) {
        	if(result[i].length()!=0) {
        		int target = Integer.parseInt(result[i]);
        		
            	if(is_prime(target)) {
            		answer+=1;
            	}
        	}
        }

        
        return answer;
        
    }
	
	public boolean is_prime(int number) {
		 
		if(number < 2) {
			return false;
		}
		
		if(number == 2) {
			return true;
		}
		
        
		for(int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String [] args) {	
		Kakao2 k = new Kakao2();
		k.solution(437674, 3);
	}
}
