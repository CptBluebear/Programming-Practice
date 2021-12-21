import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

	private static final int LIMIT = 5;
	private static final Integer[][] moveValues = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	private static final String[] moveNames = {"U", "D", "R", "L"};
	private static final String LOG_FORMAT = "%d%d%d%d";

	private static Map<String, Integer[]> moveMap = new HashMap<>();
	private static Set<String> moveLog = new HashSet<>();

	public Solution() {
		for (int i = 0; i < moveNames.length; i++) {
			moveMap.put(moveNames[i], moveValues[i]);
		}
	}

	public int solution(String dirs) {
		int x = 0;
		int y = 0;
		String[] dirArray = dirs.split("");
		for (String d : dirArray) {
			Integer[] moveInfo = moveMap.get(d);
			int tmpX = movePosition(x, moveInfo[0]);
			int tmpY = movePosition(y, moveInfo[1]);
			if (x == tmpX && y == tmpY) {
				continue;
			}
			String log = generateLog(x, y, tmpX, tmpY);
			moveLog.add(log);
			x = tmpX;
			y = tmpY;
		}
		return moveLog.size();
	}

	private int movePosition(int pos, int moveValue) {
		return LIMIT < Math.abs(moveValue + pos) ? pos : moveValue + pos;
	}

	private String generateLog(int x, int y, int tmpX, int tmpY) {
		return x + y < tmpX + tmpY ? String.format(LOG_FORMAT, x, y, tmpX, tmpY) :
			String.format(LOG_FORMAT, tmpX, tmpY, x, y);
	}
}