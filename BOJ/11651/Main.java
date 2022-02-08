import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder stringBuilder = new StringBuilder();
		List<Point> list = new LinkedList<>();
		int caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list, (o1, o2) -> {
			if (o1.getY() == o2.getY()) {
				return o1.getX() - o2.getX();
			}
			return o1.getY() - o2.getY();
		});
		for (Point p : list) {
			stringBuilder.append(p.toString() + "\n");
		}
		System.out.print(stringBuilder.toString());
	}

	public static class Point {
		private int x;
		private int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public String toString() {
			return String.format("%d %d", x, y);
		}
	}
}