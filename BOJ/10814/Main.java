import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> list = new LinkedList<>();
		int caseNum = sc.nextInt();
		sc.nextLine();
		while (caseNum-- > 0) {
			String[] data = sc.nextLine().split(" ");
			list.add(new Person(Integer.parseInt(data[0]), data[1]));
		}
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		for(Person person:list) {
			System.out.println(person);
		}
	}

	public static class Person {
		private int age;
		private String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
	}
}