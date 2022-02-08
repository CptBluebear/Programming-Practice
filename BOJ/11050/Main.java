import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(fac(n)/(fac(k) * fac(n-k)));
	}

	public static int fac(int num) {
		int result = 1;
		for(int i=1;i<=num;i++) {
			result *= i;
		}
		return result;
	}
}