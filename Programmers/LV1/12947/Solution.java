class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int cpx = x;
        
        int i=10;
        while(cpx != 0) {
            sum = sum + (cpx%i);
            cpx = (cpx - (cpx%i)) / 10;
        }
        
        return x%sum == 0 ? true : false;
        
    }
}