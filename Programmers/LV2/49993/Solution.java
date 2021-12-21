import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		int answer = 0;
		String[] skillArray = skill.split("");
		for (String skillTree : skill_trees) {
			boolean flag = true;
			List<String> skillList = new ArrayList<>(Arrays.asList(skillArray));
			for (String s : skillTree.split("")) {
				String currentSkill;
				try {
					currentSkill = skillList.get(0);
				} catch (IndexOutOfBoundsException e) {
					currentSkill = "EMPTY";
				}
				if (skillList.contains(s) && !(currentSkill.equals(s))) {
					flag = false;
					break;
				}
				if (currentSkill.equals(s)) {
					skillList.remove(currentSkill);
				}
			}
			if (flag) {
				answer++;
			}
		}
		return answer;
	}
}