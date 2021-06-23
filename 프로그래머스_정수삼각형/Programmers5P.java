package 프로그래머스_정수삼각형;

public class Programmers5P {
	public int solution(int[][] triangle) {        
        // 이문제에서 caching은 bottom-up으로 생각했을때 해당 삼각형의 계산값의 최대값은 항상 같음
		return 0;
	}

	public static void main(String[] args) {
		Programmers5P p = new Programmers5P();
		int [][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(p.solution(triangle));
	}
}
