import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        int i=0;
        for(i=0;i<seoul.length;i++) {
            if(seoul[i].equals("Kim")) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        sb.append(i);
        sb.append("에 있다");
        
        String answer = sb.toString();
        return answer;
    }
}