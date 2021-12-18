import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for(int s:scoville)
        	heap.add(s);
        
        while(heap.size() > 1)
        {
        	if(heap.peek() < K)
        	{
        		int a = heap.poll();
        		int b = heap.poll();
        		heap.add(a + b * 2);
        		answer++;
        	}
        	else
        		break;
        }
        
        if(heap.peek() < K)
        	answer = -1;
        
        return answer;
    }
}