class Solution {
    public int solution(int n) {
    	
    	int cnt = 0;
    	
    	for(int i=2;i<=n;i++)
    	{
    		boolean flag = true;
    		for(int j=2;j<= Math.sqrt(i);j++)
    		{
    			if(i%j == 0)
    			{
    				flag = false;
    				break;
    			}
    		}
    		if(flag) cnt++;
    	}
    	
        return cnt;
    }
}