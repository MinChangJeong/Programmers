package 프로그래머스_전화번호목록;

import java.util.*;
public class Programmers4P {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		HashMap <String, String> hashmap = new HashMap<String, String>();
		
		for(String phone : phone_book) {
			hashmap.put(phone, "prefix");
		}
		
		for(String phone : phone_book) {
			for(int i=0; i<phone.length(); i++) {
				if(hashmap.containsKey(phone.substring(0, i))) {
					answer = false;
					return answer;
				}
			}
		}
        return answer;
	}
	
	public static void main(String []args) {
		Programmers4P p = new Programmers4P();
		String [] phone_book = {"44","4544"};
		p.solution(phone_book);
	}
}
