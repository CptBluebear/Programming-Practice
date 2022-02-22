import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
	public int[] solution(int[] fees, String[] records) {

		Map<String, Integer> parkingLot = new HashMap<>();
		Map<String, Integer> parkingMinute = new TreeMap<>();

		for (String record : records) {
			String[] data = record.split(" ");
			Integer minute = parseMinute(data[0]);
			switch (data[2]) {
				case "IN":
					parkingLot.put(data[1], minute);
					break;
				case "OUT":
					Integer past = parkingLot.remove(data[1]);
					parkingMinute.put(data[1], parkingMinute.getOrDefault(data[1], 0) + minute - past);
					break;
			}
		}
		Integer end = parseMinute("23:59");
		for (String car : parkingLot.keySet()) {
			Integer past = parkingLot.get(car);
			parkingMinute.put(car, parkingMinute.getOrDefault(car, 0) + end - past);
		}
		int[] answer = new int[parkingMinute.size()];
		int index = 0;
		for (String car : parkingMinute.keySet()) {
			answer[index++] = calcFee(parkingMinute.get(car), fees[0], fees[1], fees[2], fees[3]);
		}

		return answer;
	}

	private int parseMinute(String s) {
		String[] data = s.split(":");
		return Integer.parseInt(data[0]) * 60 + Integer.parseInt(data[1]);
	}

	private int calcFee(int minute, int defaultTime, int defaultFee, int timePerUnit, int feePerUnit) {
		int result = defaultFee;
		minute -= defaultTime;
		if (minute > 0) {
			result += (int)(Math.ceil((double)minute / (double)timePerUnit) * feePerUnit);
		}
		return result;
	}
}