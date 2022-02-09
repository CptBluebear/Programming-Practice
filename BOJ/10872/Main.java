import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(fac(sc.nextInt()));
	}

	private static int fac(int num) {
		if (num <= 1) {
			return 1;
		}
		return num * fac(num - 1);
	}
}