import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
    	
    	int size = nums.length/2;
    	
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int num:nums)
    	{
    		if(map.get(num) == null)
    			map.put(num, 1);
    		else
    			map.put(num, map.get(num) + 1);
    	}
    	
    	for(int num:map.keySet())
    		System.out.println(num + " : " + map.get(num));
    	
    	if(size < map.keySet().size()) return size;
    	else return map.keySet().size();
    	
    }
}