import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<Integer, Integer> dp = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dp.put(1, 1);
		dp.put(2, 2);
		System.out.println(func(num));
	}

	public static int func(int num) {
		if (dp.containsKey(num)) {
			return dp.get(num);
		} else {
			int value = (func(num - 1) + func(num - 2)) % 10007;
			dp.put(num, value);
			return value;
		}
	}
}
