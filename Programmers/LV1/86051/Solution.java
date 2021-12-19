class Solution {
	public int solution(int[] numbers) {
		boolean[] flag = new boolean[10];
		for(int number:numbers) {
			flag[number] = true;
		}
		int answer = 0;
		for(int i=0;i<10;i++) {
			if(!flag[i]) {
				answer += i;
			}
		}
		return answer;
	}
}