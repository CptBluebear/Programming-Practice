import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
    	int answer = 0;
    	
    	int min = 0;
    	int max = people.length - 1;
    	Arrays.sort(people);
    	
    	while(min <= max)
    	{
    		if(min == max)
    		{
    			answer++;
    			break;
    		}
    		if(people[min] + people[max] <= limit)
    		{
    			min++;
    			max--;
    		}
    		else
    			max--;
    		answer++;
    	}

        return answer;
    }
}