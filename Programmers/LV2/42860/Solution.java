class Solution {
    public int solution(String name) {
    	
    	int answer = 0;
    	
    	int length = name.length();
    	
    	char [] arr1 = name.toCharArray();
    	char [] arr2 = new char[length];
    	
    	int cnt = 0;
    	
    	for(int i=0;i<length;i++)
    	{
    		arr2[i] = 'A';
    		if(arr1[i] != arr2[i])
    			cnt++;
    	}
    	
    	int cursor = 0;
    	
    	for(int i=0;i<cnt;i++)
    	{
    		int [] left = diffLeft(arr1, arr2, cursor);
    		int [] right = diffRight(arr1, arr2, cursor);
    		
    		if(left[0] < right[0])
    		{
    			cursor = left[1];
    			answer += left[0];
    		}
    		else
    		{
    			cursor = right[1];
    			answer += right[0];
    		}
    		
    		int a = Math.abs(arr1[cursor] - arr2[cursor]);
    		int b = 26 - a;
    		
    		answer += Math.min(a, b);
    		arr2[cursor] = arr1[cursor];
    	}
        
        return answer;
    }
    
    int [] diffLeft(char [] arr1, char [] arr2, int cursor)
    {
    	int cnt = 0;
    	while(arr1[cursor] == arr2[cursor])
    	{
    		cursor--;
    		cnt++;
    		if(cursor < 0)
    			cursor = arr1.length - 1;
    	}
    	int [] ret = {cnt, cursor};
    	return ret;
    }
    
    int [] diffRight(char [] arr1, char [] arr2, int cursor)
    {
    	int cnt = 0;
    	while(arr1[cursor] == arr2[cursor])
    	{
    		cursor++;
    		cnt++;
    		if(cursor == arr1.length)
    			cursor = 0;
    	}
    	int [] ret = {cnt, cursor};
    	return ret;
    }
}