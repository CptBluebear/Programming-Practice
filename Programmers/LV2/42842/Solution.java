class Solution {
    public int[] solution(int brown, int yellow) {
    	
        int[] answer = new int[2];
        
    	int wh = (brown+4)/2;
    	
    	for(int i=3;i<=wh/2;i++)
    	{
    		int inner = (i - 2) * (wh - i - 2);
    		if(inner == yellow)
    		{
    			answer[0] = wh - i;
    			answer[1] = i;
    			break;
    		}
    			
    	}
    	

        return answer;
    }
}