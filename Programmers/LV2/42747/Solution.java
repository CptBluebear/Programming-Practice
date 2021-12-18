import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
    	
    	Arrays.sort(citations);
    	
    	int answer;
    	for(answer=citations.length;answer>=0;answer--)
    	{
    		int cnt = 0;
    		for(int citation:citations)
    			if(answer <= citation) cnt++;
    		if(answer <= cnt) break;
    	}
    	
        return answer;
    }
}