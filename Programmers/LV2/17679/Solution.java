import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public int solution(int m, int n, String[] board) {

		List<Block>[] list = new List[n];

		char[][] carr = new char[m][n];
		for (int i = 0; i < m; i++) {
			carr[i] = board[i].toCharArray();
		}
		for (int i = 0; i < n; i++) {
			List<Block> tmp = new ArrayList<>();
			for (int j = m - 1; j >= 0; j--) {
				tmp.add(new Block(carr[j][i]));
			}
			list[i] = tmp;
		}

		Set<Block> removeBlock = new HashSet<>();

		boolean flag;
		do {
			removeBlock.clear();
			flag = false;
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < m - 1; j++) {
					if (
						list[i].get(j).getType() == list[i].get(j + 1).getType() &&
							list[i].get(j).getType() == list[i + 1].get(j).getType() &&
							list[i].get(j).getType() == list[i + 1].get(j + 1).getType() &&
							!list[i].get(j).isRemoved() &&
							!list[i].get(j + 1).isRemoved() &&
							!list[i + 1].get(j).isRemoved() &&
							!list[i + 1].get(j + 1).isRemoved()
					) {
						flag = true;
						removeBlock.add(list[i].get(j));
						removeBlock.add(list[i].get(j + 1));
						removeBlock.add(list[i + 1].get(j));
						removeBlock.add(list[i + 1].get(j + 1));
					}
				}
			}
			for (int i = 0; i < n; i++) {
				list[i].removeAll(removeBlock);
				for (int j = list[i].size(); j < m; j++) {
					list[i].add(new Block('0', true));
				}
			}
		} while (flag);

		int answer = 0;
		for (List<Block> l : list) {
			for (Block block : l) {
				if (block.isRemoved()) {
					answer++;
				}
			}
		}
		return answer;
	}

	class Block {
		private char type;
		private boolean remove;

		public Block(char type) {
			this.type = type;
		}

		public Block(char type, boolean remove) {
			this.type = type;
			this.remove = remove;
		}

		public char getType() {
			return type;
		}

		public boolean isRemoved() {
			return remove;
		}
	}
}