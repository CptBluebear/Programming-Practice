class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(b<a) {
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
        }
        for(int i=a; i<=b; i++) answer+=i;
        return answer;
    }
}