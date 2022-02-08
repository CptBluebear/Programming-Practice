import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stringBuilder = new StringBuilder();
		Map<Integer, Integer> rankData = new HashMap<>();
		TreeSet<Integer> rankBase = new TreeSet<>();
		int caseNum = Integer.parseInt(bufferedReader.readLine());
		int[] values = new int[caseNum];
		String[] data = bufferedReader.readLine().split(" ");
		for (int i = 0; i < caseNum; i++) {
			int val = Integer.parseInt(data[i]);
			rankBase.add(val);
			values[i] = val;
		}
		Iterator<Integer> iterator = rankBase.iterator();
		int cnt = 0;
		while (iterator.hasNext()) {
			rankData.put(iterator.next(), cnt++);
		}
		for (int i = 0; i < caseNum; i++) {
			stringBuilder.append(rankData.get(values[i])).append(" ");
		}
		System.out.print(stringBuilder.toString());
	}
}