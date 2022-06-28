import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
	public int solution(int N, int[][] road, int K) {

		int[] d = new int[N + 1]; //거리 결과값 저장 배열
		Arrays.fill(d, Integer.MAX_VALUE); //배열 초기화, 무한대로

		List<List<Node>> graph = new ArrayList<>(); //그래프 저장할 2중 리스트 생성
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Node>()); //그래프 생성
		}

		//데이터 초기화
		//본 문제는 양방향 그래프이기 때문에 노드 양쪽 추가함
		for (int[] data : road) {
			graph.get(data[0]).add(new Node(data[1], data[2]));
			graph.get(data[1]).add(new Node(data[0], data[2]));
		}

		PriorityQueue<Node> queue = new PriorityQueue<>(); //다익스트라 수행을 위한 우선순위 큐 생성
		queue.offer(new Node(1, 0)); //초기 시작점 큐에 삽입
		d[1] = 0; //결과값 배열 시작값 설정, 자기 자신과의 거리는 0임

		while (!queue.isEmpty()) {
			Node node = queue.poll(); //큐에서 데이터 뽑음
			int distance = node.getDistance(); //데이터 셋팅
			int current = node.getIndex(); //데이터 셋팅

			//만약 기존 거리가 현재 노드 거리보다 짧다?
			//그렇다는건 일단 여기는 직빵 경로보다 다른 경로가 빠르단 소리이기 때문에 스킵한다.
			//?? 다시 생각해보자
			if (d[current] < distance) {
				continue;
			}

			//이 노드와 이어져있는 다른 노드들 순회
			for (Node tmp : graph.get(current)) {
				int cost = d[current] + tmp.getDistance(); //현재 노드에서 tmp 노드까지 가는 비용 측정
				if (cost < d[tmp.getIndex()]) { //만약 측정한 비용이 기존에 계산된 값보다 작다면
					d[tmp.getIndex()] = cost; //적은 비용으로 교체
					queue.offer(new Node(tmp.getIndex(), cost)); //다음 탐색을 위해 tmp 노드 삽입
				}
			}
		}

		int result = Arrays.stream(d).reduce(0, (acc, cur) -> acc + (cur <= K ? 1 : 0)); //결과 카운트
		return result;
	}

	class Node implements Comparable<Node> {

		private int index;
		private int distance;

		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}

		public int getIndex() {
			return index;
		}

		public int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.getDistance();
		}
	}
}