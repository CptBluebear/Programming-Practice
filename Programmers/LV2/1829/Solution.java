import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private int[][] pic;
	private boolean[][] visited;
	private int sm;
	private int sn;
	private static final Integer[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public int[] solution(int m, int n, int[][] picture) {

		pic = picture;
		visited = new boolean[m][n];
		sm = m;
		sn = n;

		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isNotVisited(i, j) && isPainted(i, j)) {
					int result = bfs(i, j);
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, result);
				}
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int bfs(int x, int y) {
		int result = 0;
		Queue<Integer[]> queue = new LinkedList<>();
		queue.offer(new Integer[] {x, y});

		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			result++;
			visited[current[0]][current[1]] = true;
			for (Integer[] p : pos) {
				int nextX = current[0] + p[0];
				int nextY = current[1] + p[1];
				if (isMovable(nextX, nextY) && isNotVisited(nextX, nextY) && isSame(current[0], current[1], nextX,
					nextY)) {
					visited[nextX][nextY] = true;
					queue.offer(new Integer[] {nextX, nextY});
				}
			}
		}
		return result;
	}

	private boolean isNotVisited(int x, int y) {
		return !visited[x][y];
	}

	private boolean isMovable(int x, int y) {
		return 0 <= x && x < sm && 0 <= y && y < sn && isPainted(x, y);
	}

	private boolean isPainted(int x, int y) {
		return pic[x][y] != 0;
	}

	private boolean isSame(int x1, int y1, int x2, int y2) {
		return pic[x1][y1] == pic[x2][y2];
	}
}