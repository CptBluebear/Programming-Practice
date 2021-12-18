import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        ArrayList<Integer[]> arrs = new ArrayList<Integer[]>();
        
        for(int i=0;i<nums.length;i++)
        	for(int j=i+1;j<nums.length;j++)
        		for(int k=j+1;k<nums.length;k++)
        		{
        			Integer [] arr = new Integer[3];
        			arr[0] = nums[i];
        			arr[1] = nums[j];
        			arr[2] = nums[k];
        			arrs.add(arr);
        		}
        
        for(Integer [] arr:arrs)
        	if(isPrimeNumber((arr[0]+arr[1]+arr[2]))) answer++;

        return answer;
    }
    
	public boolean isPrimeNumber(int n)
	{
		if ( n == 1 ) return false;
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0) return false;
		return true;
	}

}