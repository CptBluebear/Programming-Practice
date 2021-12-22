class Solution {
	public int[] solution(String s) {
		int[] answer = {0, 0};

		while (!s.equals("1")) {
			String tmp = s.replace("0", "");
			answer[1] += s.length() - tmp.length();
			s = Integer.toBinaryString(tmp.length());
			answer[0]++;
		}
		return answer;
	}
}