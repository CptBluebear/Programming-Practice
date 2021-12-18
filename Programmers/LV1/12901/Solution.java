import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        
        Calendar c = Calendar.getInstance();
        c.set(2016, a-1, b);
        
        return day[c.get(Calendar.DAY_OF_WEEK)-1];
    }
}