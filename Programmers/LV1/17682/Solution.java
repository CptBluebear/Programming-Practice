import java.util.ArrayList;

class Solution {
    public int solution(String dartResult) {
    	
    	char[] arr = dartResult.toCharArray();
    	
    	ArrayList<Integer> scores = new ArrayList<Integer>();
    	
    	boolean flag = false;
    	int score = 0;
    	for(char ch:arr)
    	{
    		if(Character.isDigit(ch))
    		{
    			if(flag)
    			{
    				scores.add(score);
    				flag = false;
    				score = 0;
    			}
    			if(score != 0)
    				score *= 10;
    			score += Integer.parseInt(Character.toString(ch));
    		}
    		else if(Character.isLetter(ch))
    		{
    			switch (ch) {
					case 'S':
						score = (int)Math.pow(score, 1);
						break;
					case 'D':
						score = (int)Math.pow(score, 2);
						break;
					case 'T':
						score = (int)Math.pow(score, 3);
						break;
				}
    			flag = true;
    		}
    		else
    		{
    			switch (ch) {
					case '*':
						if(scores.size() > 0)
							scores.set( scores.size()-1, scores.get(scores.size()-1) * 2 );
						score *=2;
						break;
					case '#':
						score *= -1;
						break;
				}
    		}
    	}
    	scores.add(score);
    	
    	int answer = 0;
    	for(int a:scores)
    		answer+=a;

        return answer;
    }
}