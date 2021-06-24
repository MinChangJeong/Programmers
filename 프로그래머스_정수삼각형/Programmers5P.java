package 프로그래머스_정수삼각형;

// 동적계획법 (memoization활용)
public class Programmers5P {
	public int solution(int[][] triangle) {   
		int answer = 0;
				
		int [][] memoization = new int [triangle.length][triangle.length];
		
       for(int i=0; i<triangle.length; i++) {
    	   for(int j=0; j<=i; j++) {
    		   memoization[i][j] = -1;
    	  }
       } 
       
       for(int layer=0; layer<triangle.length; layer++) {
    	   for(int idx=0; idx<=layer; idx++) {
    		   if(layer == 0) {
    			   memoization[layer][idx] = triangle[layer][idx];
    		   }
    		   else if(idx == layer) {
    			   memoization[layer][idx] = triangle[layer][idx] + memoization[--layer][--idx];
    			   layer+=1;
    			   idx+=1;
    		   }
    		   else if(idx == 0) {
    			   memoization[layer][idx] = triangle[layer][idx] + memoization[--layer][idx];
    			   layer+=1;
    		   }
    		   else {
    			   int node = triangle[layer][idx];
				   memoization[layer][idx] = Math.max(node + memoization[--layer][idx], node+memoization[layer][--idx]);
				   layer+=1;
				   idx+=1;
						   
    		   }
    	   }
       }
       
       for(int i = 0; i<memoization[memoization.length-1].length; i++) {
    	   if(answer<=memoization[memoization.length-1][i])
    		   answer = memoization[memoization.length-1][i];
       }
       return answer;
	}
}
