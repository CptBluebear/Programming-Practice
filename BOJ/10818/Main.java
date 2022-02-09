import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		int tmp = sc.nextInt();
		int max = tmp;
		int min = tmp;

		for(int i=1;i<caseNum;i++) {
			tmp = sc.nextInt();
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}
		System.out.printf("%d %d", min, max);
	}
}