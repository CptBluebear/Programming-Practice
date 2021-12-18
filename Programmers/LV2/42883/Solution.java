import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
    	
    	Stack<Character> stack = new Stack<Character>();
    	char [] arr = number.toCharArray();
    	
    	int cnt = 0;
    	boolean flag = false;
    	
    	stack.push(arr[0]);
    	for(int i=1;i<arr.length;i++)
    	{
    		if(flag)
    		{
    			stack.push(arr[i]);
    			continue;
    		}
    		while(!stack.isEmpty() && stack.peek() < arr[i])
    		{
    			stack.pop();
    			cnt++;
    			if(cnt == k)
    			{
    				flag = true;
    				break;
    			}
    		}
    		stack.push(arr[i]);
    	}
    	
    	
    	for(int i = cnt;i<k;i++)
    		stack.pop();
    	
    	
    	StringBuilder sb = new StringBuilder();
    	while(!stack.isEmpty())
    		sb.append(stack.pop());
    	
        return sb.reverse().toString();
    }
}