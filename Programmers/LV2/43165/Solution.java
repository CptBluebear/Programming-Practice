import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] numbers, int target) {
		List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());

		List<List<Integer>> powerSet = powerSet(list);
		List<Integer> sumList = new ArrayList<>();
		for (List<Integer> tmp : powerSet) {
			int sum = 0;
			for (Integer i : tmp) {
				sum += i;
			}
			sumList.add(sum);
		}
		int numbersSum = 0;
		for (Integer i : list) {
			numbersSum += i;
		}

		int answer = 0;
		for (Integer s : sumList) {
			if (numbersSum - 2 * s == target) {
				answer++;
			}
		}

		return answer;
	}

	public <T extends List> List<T> powerSet(T t) {
		List<T> results = new ArrayList<>();
		Stack stack = new Stack();
		powerSet_InnerMethod(stack, t, 0, results);
		return results;
	}

	private <T extends List> void powerSet_InnerMethod(Stack stack, T t, int pivot, List<T> results) {
		if(pivot >= t.size()) {
			results.add((T)new ArrayList(stack));
		} else {
			stack.push(t.get(pivot));
			powerSet_InnerMethod(stack, t, pivot+1, results);
			stack.pop();
			powerSet_InnerMethod(stack, t, pivot+1, results);
		}
	}
}