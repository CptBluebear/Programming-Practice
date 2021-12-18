import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
    	
    	Arrays.sort(d);
        int answer = 0;
        
    	for(int a:d)
    	{
    		if(budget-a >= 0)
    		{
    			budget -= a;
    			answer++;
    		}
    	}

        return answer;
    }
}