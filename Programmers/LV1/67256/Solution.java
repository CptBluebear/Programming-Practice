class Solution {
    public String solution(int[] numbers, String hand) {
    	
    	int [][] pad = {
    			{1,2,3},
    			{4,5,6},
    			{7,8,9},
    			{-1,0,-1}
    	};
    	
    	int [] posLeft = {3,0};
    	int [] posRight = {3,2};
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int number:numbers)
    	{
    		int i = 0;
    		int j = 0;
    		boolean flag = false;
    		
    		for(i=0;i<pad.length;i++)
    		{
    			for(j=0;j<pad[i].length;j++)
    			{
    				if(number == pad[i][j])
    				{
    					flag = true;
    					break;
    				}
    			}
    			if(flag) break;
    		}
    		
    		switch (number) {
				case 1:
				case 4:
				case 7:
					sb.append("L");
					posLeft[0] = i;
					posLeft[1] = j;
					break;
	
				case 3:
				case 6:
				case 9:
					sb.append("R");
					posRight[0] = i;
					posRight[1] = j;
					break;
				
				case 2:
				case 5:
				case 8:
				case 0:
					int leftLen = Math.abs(i - posLeft[0]) + Math.abs(j - posLeft[1]);
					int rightLen = Math.abs(i - posRight[0]) + Math.abs(j - posRight[1]);
					
					if(leftLen < rightLen || (leftLen == rightLen && hand.equals("left")))
					{
						sb.append("L");
						posLeft[0] = i;
						posLeft[1] = j;
					}
					else if(leftLen > rightLen || (leftLen == rightLen && hand.equals("right")))
					{
						sb.append("R");
						posRight[0] = i;
						posRight[1] = j;
					}
					break;
			}
    	}
    	
        String answer = sb.toString();
        return answer;
    }
}