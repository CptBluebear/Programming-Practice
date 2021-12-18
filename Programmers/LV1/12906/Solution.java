import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
    	ArrayList<Integer> array = new ArrayList<Integer>();
    	
    	int cache = arr[0];
    	array.add(arr[0]);
    	for(int tmp:arr)
    	{
    		if(tmp == cache) continue;
    		else
    		{
    			array.add(tmp);
    			cache = tmp;
    		}
    	}
    	
        int[] answer = new int[array.size()];
        for(int i=0;i<array.size();i++) answer[i] = array.get(i);

        return answer;
    }
}