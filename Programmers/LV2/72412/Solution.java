import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		List<Applicant> applicantList = new ArrayList<>();
		for (String i : info) {
			String[] infoData = i.split(" ");
			applicantList.add(
				new Applicant(infoData[0], infoData[1], infoData[2], infoData[3], Integer.parseInt(infoData[4])));
		}
		int cnt = 0;
		for (String q : query) {
			List<Applicant> list = new ArrayList<>(applicantList);
			String[] queryData = q.split(" ");
			String language = queryData[0];
			String group = queryData[2];
			String career = queryData[4];
			String food = queryData[6];
			int score = Integer.parseInt(queryData[7]);
			list = list.stream()
				.filter(o -> o.checkCondition(language, group, career, food, score))
				.collect(Collectors.toList());
			answer[cnt++] = list.size();
		}
		return answer;
	}

	class Applicant {
		String language;
		String group;
		String career;
		String food;
		int score;

		public Applicant(String language, String group, String career, String food, int score) {
			this.language = language;
			this.group = group;
			this.career = career;
			this.food = food;
			this.score = score;
		}

		public boolean checkCondition(String language, String group, String career, String food, int score) {
			if (checkLanguage(language) && checkGroup(group) && checkCareer(career) && checkFood(food) && checkScore(
				score)) {
				return true;
			}
			return false;
		}

		private boolean checkLanguage(String language) {
			if (language.equals("-")) {
				return true;
			}
			return this.language.equals(language);
		}

		private boolean checkGroup(String group) {
			if (group.equals("-")) {
				return true;
			}
			return this.group.equals(group);
		}

		private boolean checkCareer(String career) {
			if (career.equals("-")) {
				return true;
			}
			return this.career.equals(career);
		}

		private boolean checkFood(String food) {
			if (food.equals("-")) {
				return true;
			}
			return this.food.equals(food);
		}

		private boolean checkScore(int score) {
			return this.score >= score;
		}
	}
}