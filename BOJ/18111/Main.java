import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] initData = bufferedReader.readLine().split(" ");
		int length = Integer.parseInt(initData[0]);
		int width = Integer.parseInt(initData[1]);
		int block = Integer.parseInt(initData[2]);
		int[] world = new int[length * width];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int answerTime = Integer.MAX_VALUE;
		int answerHeight = 0;
		for (int i = 0; i < length; i++) {
			String[] tmp = bufferedReader.readLine().split(" ");
			for (int j = 0; j < width; j++) {
				int value = Integer.parseInt(tmp[j]);
				max = Math.max(max, value);
				min = Math.min(min, value);
				world[i * width + j] = value;
			}
		}
		//System.out.println(Arrays.toString(world));
		for (int i = max; i >= min; i--) {
			int remove = 0;
			int set = 0;
			for (int w : world) {
				if (w > i) {
					remove += (w - i);
				} else if (w < i) {
					set += (i - w);
				}
			}
			if ((remove + block) < set) {
				continue;
			} else {
				int time = remove * 2 + set;
				if (answerTime <= time) {
					break;
				} else {
					answerHeight = i;
					answerTime = time;
				}
			}
		}
		System.out.printf("%d %d", answerTime, answerHeight);
	}
}