import java.util.Arrays;

class Solution {
    public String solution(String s) {
    	char [] str = s.toCharArray();
    	Arrays.sort(str);
    	char [] str2 = new char[str.length];
    	for(int i=0;i<str.length;i++)
    		str2[i] = str[str.length-1-i];
        String answer = new String(str2);
        return answer;
    }
}