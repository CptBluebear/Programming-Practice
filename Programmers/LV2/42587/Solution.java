import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
    	
    	Queue<Integer[]> printQueue = new LinkedList<Integer[]>();
    	ArrayList<Integer[]> arr = new ArrayList<Integer[]>();
    	
    	for(int i=0;i<priorities.length;i++)
    	{
    		Integer [] tuple = {i, priorities[i]};
    		printQueue.add(tuple);
    	}
    	
    	while(printQueue.size() != 0)
    	{
    		Integer [] tuple = printQueue.poll();
    		boolean flag = false;
    		for(Integer [] tmp:printQueue)
    		{
    			if(tuple[1] < tmp[1])
    			{
    				flag = true;
    				break;
    			}
    		}
    		if(flag)
    		{
    			printQueue.add(tuple);
    			continue;
    		}
    		else
    			arr.add(tuple);
    	}
    	
    	int answer = 0;
    	
    	for(answer=0;answer<arr.size();answer++)
    		if(arr.get(answer)[0] == location)
    			break;
        
        return answer+1;
    }
}