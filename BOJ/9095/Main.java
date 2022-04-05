import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<Integer, Integer> dp = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int caseNum = Integer.parseInt(reader.readLine());
		dp.put(1, 1);
		dp.put(2, 2);
		dp.put(3, 4);
		StringBuilder stringBuilder = new StringBuilder();
		while (caseNum-- > 0) {
			int num = Integer.parseInt(reader.readLine());
			stringBuilder.append(func(num)).append("\n");
		}
		System.out.println(stringBuilder);
	}

	public static int func(int num) {
		if (dp.containsKey(num)) {
			return dp.get(num);
		}
		int result = func(num - 1) + func(num - 2) + func(num - 3);
		dp.put(num, result);
		return result;
	}
}