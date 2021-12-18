import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    	
    	Integer [] arr = new Integer[progresses.length];
    	int length = progresses.length;
    	
    	
    	for(int i=0;i<length;i++)
    		arr[i] = (int)Math.ceil( (double)(100 - progresses[i]) / (double)speeds[i] );
    	
    	ArrayList<Integer> day = new ArrayList<Integer>();
    	
    	int cursor = 0;
    	while(cursor < length)
    	{
    		int cnt = 0;
    		while(arr[cursor] <= 0)
    		{
    			cnt++;
    			cursor++;
    			if(cursor >= length)
    				break;
    		}
    		if(cnt != 0)
    			day.add(cnt);
    		for(int i=cnt;i<length;i++)
    			arr[i] -= 1;
    	}    		
    	
    	int [] answer = new int[day.size()];
    	for(int i=0;i<answer.length;i++)
    		answer[i] = day.get(i);
    	
        return answer;
    }
}