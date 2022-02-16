import java.util.LinkedList;
import java.util.Queue;

class Solution {

	private static final Integer[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private int[][] map;
	private boolean[][] visited;
	private int rows;
	private int columns;

	public int solution(int[][] maps) {
		map = maps;
		rows = map.length;
		columns = map[0].length;
		visited = new boolean[rows][columns];
		return dfs();
	}

	private int dfs() {
		Queue<Integer[]> queue = new LinkedList<>();
		Integer[] start = {0, 0};
		visited[0][0] = true;
		queue.offer(start);
		while (!queue.isEmpty()) {
			Integer[] current = queue.poll();
			for (Integer[] move : pos) {
				int x = current[0] + move[0];
				int y = current[1] + move[1];
				if (isMovable(x, y)) {
					map[x][y] = map[current[0]][current[1]] + 1;
					queue.offer(new Integer[] {x, y});
					visited[x][y] = true;
				}
			}
		}
		return map[rows - 1][columns - 1] != 1 ? map[rows - 1][columns - 1] : -1;
	}

	private boolean isMovable(int x, int y) {
		if (!(0 <= x && x <= rows - 1 && 0 <= y && y <= columns - 1)) {
			return false;
		}
		if (visited[x][y]) {
			return false;
		}
		if (map[x][y] == 0) {
			return false;
		}
		return true;
	}
}