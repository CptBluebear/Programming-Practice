import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		int target = sc.nextInt();
		StringBuilder stringBuilder = new StringBuilder();
		while (caseNum-- > 0) {
			int tmp = sc.nextInt();
			if (tmp < target) {
				stringBuilder.append(tmp + " ");
			}
		}
		System.out.println(stringBuilder.toString());
	}
}