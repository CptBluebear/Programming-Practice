class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int tmp1 = n;
        int tmp2 = m;
        if(tmp1 < tmp2)
        {
            int t = tmp1;
            tmp1 = tmp2;
            tmp2 = t;
        }
        while(tmp2 > 0)
        {
        	int r = tmp2;
        	tmp2 = tmp1 % tmp2;
        	tmp1 = r;
        }
        answer[0] = tmp1;
        answer[1] = (n*m) / tmp1;
        
        
        return answer;
    }
}