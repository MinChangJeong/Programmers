package 프로그래머스_전화번호목록;

// 이 코드의 문제 hash로 구현하지 못해 시간초과 에러가 남..
public class Programmers4 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String phone : phone_book) {
        	for(String target : phone_book) {
        		String [] num = target.split(phone);
        		if(num.length == 2 && num[0].length()==0) {
        			return false;
        		}
        	}
        }
        return answer;
    }
}