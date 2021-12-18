import java.util.ArrayList;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    	
    	ArrayList<Integer> lostArray = new ArrayList<Integer>();
    	ArrayList<Integer> reserveArray = new ArrayList<Integer>();
    	ArrayList<Integer> lostArrayTmp = new ArrayList<Integer>();
    	ArrayList<Integer> reserveArrayTmp = new ArrayList<Integer>();
    	for(int a:lost) lostArrayTmp.add(a);
    	for(int a:reserve) reserveArrayTmp.add(a);
    	for(int a:lost) lostArray.add(a);
    	for(int a:reserve) reserveArray.add(a);
    	
    	for(int a:lostArrayTmp)
    	{
    		if(reserveArrayTmp.indexOf(a) != -1)
    		{
    			lostArray.remove(lostArray.indexOf(a));
    			reserveArray.remove(reserveArray.indexOf(a));
    		}
    	}
        
    	int lostnum = lostArray.size();
    	
    	for(int a:lostArray)
    	{
    		if(reserveArray.indexOf(a-1) != -1)
    		{
    			reserveArray.remove(reserveArray.indexOf(a-1));
    			lostnum-=1;
    		}
    		else if(reserveArray.indexOf(a+1) != -1)
    		{
    			reserveArray.remove(reserveArray.indexOf(a+1));
    			lostnum-=1;
    		}
    	}
    	
    	
        int answer = n-lostnum;
        return answer;
    }
}