import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		HashSet<Integer> set = new HashSet<>();
		List<Integer> defaultAll = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		while (caseNum-- > 0) {
			String[] command = bufferedReader.readLine().split(" ");
			int value;
			switch (command[0]) {
				case "add":
					value = Integer.parseInt(command[1]);
					set.add(value);
					break;
				case "remove":
					value = Integer.parseInt(command[1]);
					set.remove(value);
					break;
				case "check":
					value = Integer.parseInt(command[1]);
					if (set.contains(value)) {
						stringBuilder.append("1\n");
					} else {
						stringBuilder.append("0\n");
					}
					break;
				case "toggle":
					value = Integer.parseInt(command[1]);
					if (set.contains(value)) {
						set.remove(value);
					} else {
						set.add(value);
					}
					break;
				case "all":
					set.clear();
					set.addAll(defaultAll);
					break;
				case "empty":
					set.clear();
					break;
			}
		}
		System.out.print(stringBuilder.toString());
	}
}