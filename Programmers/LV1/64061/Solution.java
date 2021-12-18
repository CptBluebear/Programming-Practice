import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> pops = new Stack<Integer>();
        
        for(int i=0;i<moves.length;i++) {
            int position = moves[i];
            for(int j=0;j<board.length;j++) {
                System.out.println(board[j][position-1]);
                if(board[j][position-1] == 0) {
                    continue;
                }
                if(!pops.empty() && pops.peek() == board[j][position-1]) {
                    pops.pop();
                    answer+=2;
                }
                else {
                    pops.push(board[j][position-1]);
                }
                board[j][position-1] = 0;
                break;
            }
        }
        System.out.println(pops);
        return answer;
    }
}