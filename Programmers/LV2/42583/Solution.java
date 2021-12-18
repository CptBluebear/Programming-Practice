import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
    	int answer = 0;
    	int load = 0;
    	int num = 0;
    	
    	Queue<Integer> bridge = new LinkedList<Integer>();
    	ArrayList<Integer> timeChecker = new ArrayList<Integer>();
    	
    	int index = 0;
    	do
    	{
    		for(int i=0;i<timeChecker.size();i++)
    		{
    			//System.out.println(timeChecker.get(i));
    			timeChecker.set(i, timeChecker.get(i) - 1);
    		}
    		while(!timeChecker.isEmpty() && timeChecker.get(0) == 0)
    		{
    			load -= bridge.poll();
    			num--;
    			timeChecker.remove(0);
    		}
    		
    		if(index < truck_weights.length && num < bridge_length && load + truck_weights[index] <= weight)
    		{
    			bridge.add(truck_weights[index]);
    			num++;
    			load += truck_weights[index++];
    			timeChecker.add(bridge_length);
    		}
    		
    		answer++;
    	}
    	while(!timeChecker.isEmpty());
    	
        return answer;
    }
}