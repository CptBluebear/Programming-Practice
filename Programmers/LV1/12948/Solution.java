import java.util.*;

class Solution {
    public String solution(String phone_number) {
        
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<phone_number.length()-4;i++) buffer.append("*");
        buffer.append(phone_number.substring(phone_number.length()-4));
        
        
        String answer = buffer.toString();
        return answer;
    }
}