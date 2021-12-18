import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        System.out.println(set);
        
        int[] answer = new int[set.size()];
        int i=0;
        for(Integer value:set) {
            answer[i++] = value;
        }
        Arrays.sort(answer);
        return answer;
    }
}