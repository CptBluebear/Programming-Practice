import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
    	
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	ArrayList<Double> failRate = new ArrayList<Double>();
    	
    	for(int stage:stages)
    		arr.add(stage);
    	Collections.sort(arr);
    	
    	for(int i=1;i<=N;i++)
    	{
    		int cnt = 0;
    		for(int stage:arr)
    		{
    			if(stage == i)
    				cnt++;
    		}
    		if(cnt != 0) failRate.add((double)cnt / (double)arr.size());
    		else failRate.add(0.0);
    		while(arr.remove((Object)i));
    	}
    	
    	HashMap<Integer, Double> map = new HashMap<Integer, Double>();
    	
    	for(int i=1;i<=failRate.size();i++)
    		map.put(i, failRate.get(i-1));
    	
		ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
		
		Collections.sort(keys, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        int[] answer = new int[N];
        int cnt = 0;
		for(Integer key : keys)
			answer[cnt++] = key;
    	
        return answer;
    }
}