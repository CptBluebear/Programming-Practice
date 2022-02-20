import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
	public int[] solution(String[] genres, int[] plays) {

		Map<String, Integer> genrePlayCount = new HashMap<>();
		List<Music> musicList = new LinkedList<>();
		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < genres.length; i++) {
			genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
			musicList.add(new Music(i, genres[i], plays[i]));
		}

		Collections.sort(musicList, new Comparator<Music>() {
			@Override
			public int compare(Music o2, Music o1) {
				if (genrePlayCount.get(o1.genre) != genrePlayCount.get(o2.genre)) {
					return genrePlayCount.get(o1.genre) - genrePlayCount.get(o2.genre);
				}
				if (o1.playCount != o2.playCount) {
					return o1.playCount - o2.playCount;
				}
				return o2.index - o1.index;
			}
		});

		for (String key : genrePlayCount.keySet()) {
			genrePlayCount.put(key, 2);
		}

		for (Music music : musicList) {
			if (genrePlayCount.get(music.genre) != 0) {
				genrePlayCount.put(music.genre, genrePlayCount.get(music.genre) - 1);
				results.add(music.index);
			}
		}

		int[] answer = new int[results.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = results.get(i);
		}
		return answer;
	}

	class Music {
		int index;
		String genre;
		int playCount;

		public Music(int index, String genre, int playCount) {
			this.index = index;
			this.genre = genre;
			this.playCount = playCount;
		}
	}
}