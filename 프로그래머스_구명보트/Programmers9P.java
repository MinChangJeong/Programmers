package ���α׷��ӽ�_����Ʈ;

import java.util.*;

public class Programmers9P {
	public int solution(int[] people, int limit) {
        int rightPoint = people.length-1;
        int result = 0;
        Arrays.sort(people);
        
        for(int i = 0; i <= rightPoint; i++) {
            while(i < rightPoint && people[i] + people[rightPoint--] > limit) {
                result++;
            }
            result++;
        }
        
        return result;
        
    }
}
