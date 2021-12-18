class Solution {
    public int[] solution(int[] answers) {
    	
    	int [][] pattern = {
    			{1,2,3,4,5},
    			{2,1,2,3,2,4,2,5},
    			{3,3,1,1,2,2,4,4,5,5}
    	};
    	
    	int [] score = new int[pattern.length];
    	
    	for(int i=0;i<pattern.length;i++)
    	{
    		for(int j=0;j<answers.length;j++)
    		{
    			if(answers[j] == pattern[i][j%pattern[i].length])
    				score[i]++;
    			else
    				continue;
    		}
    	}
    	
    	int cnt = 0;
    	int max = 0;
    	for(int a:score)
    	{
    		if(max < a)
    		{
    			max = a;
    			cnt = 1;
    		}
    		else if(max == a)
    			cnt++;
    	}
    	
    	
        int[] answer = new int[cnt];
        cnt = 0;
        for(int i=0;i<score.length;i++)
        {
        	if(max == score[i])
        		answer[cnt++] = i+1;
        }
        return answer;
    }
}