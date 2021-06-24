package 프로그래머스_전화번호목록;

import java.util.*;
// 이 코드의 문제 hash로 구현하지 못해 시간초과 에러가 남..
// 알고리즘 문제에서 "노가다 문자열 비교 작업"이 필요하다면 해시를 먼저 떠올리면 좋다.
public class Programmers4 {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=i+1; j<phone_book.length; j++) {
        		if(phone_book[i] == phone_book[j])
        			continue;
        		if(phone_book[j].indexOf(phone_book[i]) == 0) {
        			answer = false;
        			return false;
        		}
        	}
        }
//        풀이 2
//        for(String phone : phone_book) {
//        	for(String target : phone_book) {
//        		if(phone.length() <= target.length()) {
//        			if(!target.equals(phone) && target.contains(phone) && target.indexOf(phone) == 0) {
//        				answer = false;
//        				break;
//        			}
//        		}
//        	}
//        }
        
        return answer;
    }
}