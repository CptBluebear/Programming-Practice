import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		int sum = 0;
		char[] arr = sc.nextLine().toCharArray();
		for(char c:arr) {
			sum += c-48;
		}
		System.out.println(sum);
	}
}