import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        
        for(int[] com:commands)
        {
        	int start = com[0];
        	int end = com[1];
        	int index = com[2];
        	int[] tmparray = Arrays.copyOfRange(array, start-1, end);
        	Arrays.sort(tmparray);
        	ans.add(tmparray[index-1]);
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++)
        	answer[i] = ans.get(i);
        return answer;
    }
}