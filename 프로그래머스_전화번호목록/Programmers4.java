package ���α׷��ӽ�_��ȭ��ȣ���;

// �� �ڵ��� ���� hash�� �������� ���� �ð��ʰ� ������ ��..
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