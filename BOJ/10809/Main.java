import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] answer = new int[26];
		for (int i = 0; i < 26; i++) {
			answer[i] = -1;
		}
		char[] data = sc.nextLine().toCharArray();
		for (int i = 0; i < data.length; i++) {
			int index = data[i] - 97;
			if (answer[index] == -1) {
				answer[index] = i;
			}
		}
		for (int a : answer) {
			System.out.print(a + " ");
		}
	}
}