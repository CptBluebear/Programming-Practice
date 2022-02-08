import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Point> list = new LinkedList<>();
		StringBuilder stringBuilder = new StringBuilder();
		int caseNum = sc.nextInt();
		while (caseNum-- > 0) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.getX() == o2.getX()) {
					return o1.getY() - o2.getY();
				}
				return o1.getX() - o2.getX();
			}
		});
		for(Point p:list) {
			stringBuilder.append(p.toString() + "\n");
		}
		System.out.println(stringBuilder.toString());
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