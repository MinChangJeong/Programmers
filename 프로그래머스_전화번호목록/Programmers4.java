package ���α׷��ӽ�_��ȭ��ȣ���;

import java.util.*;
// �� �ڵ��� ���� hash�� �������� ���� �ð��ʰ� ������ ��..
// �˰��� �������� "�밡�� ���ڿ� �� �۾�"�� �ʿ��ϴٸ� �ؽø� ���� ���ø��� ����.
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
//        Ǯ�� 2
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