class Solution {
	public String solution(String s) {
		String[] data = s.split("");
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = true;
		for(String c:data) {
			if(flag) {
				c = c.toUpperCase();
				flag = false;
			} else {
				c = c.toLowerCase();
			}
			if(c.equals(" ")) {
				flag = true;
			}
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}
}