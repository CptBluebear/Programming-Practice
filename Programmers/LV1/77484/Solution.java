class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
    	
    	int cnt = 0;
    	int zero = 0;
    	
    	for(int l:lottos)
    	{
    		if(l == 0)
    		{
    			zero++;
    			continue;
    		}
    		for(int w:win_nums)
    		{
    			if(l == w)
    			{
    				cnt++;
    				break;
    			}
    		}
    	}
    	
        int[] answer = new int[2];
        answer[0] = getGrade(cnt+zero);
        answer[1] = getGrade(cnt);
        
        return answer;
    }
    
    public int getGrade(int num)
    {
    	int result = 0;
    	switch (num) {
			case 6:
				result = 1;
				break;
			case 5:
				result = 2;
				break;
			case 4:
				result = 3;
				break;
			case 3:
				result = 4;
				break;
			case 2:
				result = 5;
				break;
			default:
				result = 6;
				break;
		}
    	return result;
    }
}