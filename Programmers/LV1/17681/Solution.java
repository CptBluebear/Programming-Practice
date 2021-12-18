class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
    	
    	String [] dec1 = new String[n];
    	String [] dec2 = new String[n];
    	
    	String format = "%0" + n + "d";
    	
    	for(int i=0;i<n;i++)
    		dec1[i] = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i]).toString()));
    	for(int i=0;i<n;i++)
    		dec2[i] = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i]).toString()));
    	
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(dec1[i].charAt(j) == '1' || dec2[i].charAt(j) == '1') sb.append("#");
        		else sb.append(" ");
        	}
        	answer[i] = sb.toString();
        	sb.setLength(0);
        }
        return answer;
    }
}