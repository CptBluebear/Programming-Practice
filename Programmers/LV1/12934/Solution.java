class Solution {
    public long solution(long n) {
        return Math.sqrt(n) % 1 == 0.0 ? (long)Math.pow(Math.sqrt(n)+1, 2) : (long)-1;
    }
}