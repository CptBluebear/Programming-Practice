import java.util.*;

class Solution {
    public long solution(long n) {
        
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        while(n != 0) {
            arr.add(Integer.valueOf((int)(n%10)));
            n = n/10;
        }
        Collections.sort(arr);
        Collections.reverse(arr);
        long answer = 0;
        
        for(int a:arr) {
            answer*=10;
            answer+=a;
        }
        
        return answer;
    }
}