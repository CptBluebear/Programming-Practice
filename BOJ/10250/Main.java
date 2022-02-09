import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			int y = n % h;
			int x = n / h + 1;
			if(n % h == 0) {
				y = h;
				x = n / h;
			}
			System.out.println(String.format("%d%02d", y, x));
		}
	}
}