package Kakao;

import java.util.*;

public class Kakao3 {
	public int[] solution(int[] fees, String[] records) {
        
        double basic_time = fees[0];
        int basic_fee = fees[1];
        double unit_time = fees[2];
        int unit_fee = fees[3];
        
        Map<String, Integer> in_car_times = new HashMap<String, Integer>();
        
        Map<String, Integer> stack_car_times = new TreeMap<String, Integer>();
        
        
        for(int i=0; i<records.length; i++ ) {
        	String [] record = records[i].split(" ");
        	
        	String time = record[0];
        	String car_num = record[1];
        	String type = record[2];
        
        	String [] times = time.split(":");
        	int c_time = Integer.parseInt(times[0])*60 + Integer.parseInt(times[1]);
        	
        	// 입차인 경우
        	if(type.equals("IN")) {
        		in_car_times.put(car_num, c_time);
        	}
        	// 출차인 경우
        	else {
        		int in_car_time = in_car_times.get(car_num);
        		
        		int out_car_time = c_time;
        		
        		int t_time = out_car_time - in_car_time;
        		
        		int stack_time = stack_car_times.getOrDefault(car_num, 0);
        		
        		stack_car_times.put(car_num, stack_time+t_time);
        		
        	}
        	
        }

        for (Map.Entry<String, Integer> entry : in_car_times.entrySet()) {
        	int stack_time = stack_car_times.getOrDefault(entry.getKey(), 0);
        	
        	int t_time = 1439 - entry.getValue();
        	
        	stack_car_times.put(entry.getKey(), stack_time + t_time);
        	
        	in_car_times.remove(entry.getKey());
        }
        
        
        int [] answer = new int[stack_car_times.size()]; 
        
        int idx = 0;
        for (Map.Entry<String, Integer> entry : stack_car_times.entrySet()) {	
        	int stack_time = entry.getValue();
        	
        	if(stack_time <= basic_time) {
        		int fee = basic_fee;
        		
        		answer[idx++] = fee;
        	}
        	else {    	
        		int fee = (int) (basic_fee + Math.ceil( (stack_time-basic_time) / unit_time)*unit_fee); 
        		
        		answer[idx++] = fee;
        	}
        	
        }
        
        
        return answer;
    }

	public static void main(String [] args) {	
		Kakao3 k = new Kakao3();
		
		int [] fees = {180, 5000, 10, 600};
		String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

		k.solution(fees, records);
	}
}
