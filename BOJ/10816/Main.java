import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		int caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			int key = sc.nextInt();
			int num = 1;
			if (map.containsKey(key)) {
				num = map.get(key) + 1;
			}
			map.put(key, num);
		}
		caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			Integer integer = map.get(sc.nextInt());
			if(integer == null) {
				integer = 0;
			}
			stringBuilder.append(integer + " ");
		}
		System.out.println(stringBuilder.toString());
	}
}