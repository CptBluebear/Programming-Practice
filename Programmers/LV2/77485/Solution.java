class Solution {

	private int[][] map;

	public int[] solution(int rows, int columns, int[][] queries) {

		int[] answer = new int[queries.length];
		map = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = i * columns + j + 1;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			answer[i] = spin(queries[i]);
		}

		return answer;
	}

	private int spin(int[] query) {

		int min = Integer.MAX_VALUE;

		int[] p1 = {query[0] - 1, query[1] - 1};
		int[] p2 = {query[2] - 1, query[3] - 1};

		int tmp = map[p1[0]][p1[1]];
		min = tmp;

		for (int i = p1[0] + 1; i <= p2[0]; i++) {
			min = Math.min(min, map[i][p1[1]]);
			map[i - 1][p1[1]] = map[i][p1[1]];
		}

		for (int i = p1[1] + 1; i <= p2[1]; i++) {
			min = Math.min(min, map[p2[0]][i]);
			map[p2[0]][i - 1] = map[p2[0]][i];
		}

		for (int i = p2[0] - 1; i >= p1[0]; i--) {
			min = Math.min(min, map[i][p2[1]]);
			map[i + 1][p2[1]] = map[i][p2[1]];
		}

		for (int i = p2[1] - 1; i >= p1[1]; i--) {
			min = Math.min(min, map[p1[0]][i]);
			map[p1[0]][i + 1] = map[p1[0]][i];
		}

		map[p1[0]][p1[1] + 1] = tmp;

		return min;
	}
}