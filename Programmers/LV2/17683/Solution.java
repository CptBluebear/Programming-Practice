import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class Solution {
	public String solution(String m, String[] musicinfos) throws ParseException {

		List<MusicInfo> list = new ArrayList<>();
		m = convert(m);

		for (String info : musicinfos) {
			String[] data = info.split(",");
			list.add(new MusicInfo(data[0], data[1], data[2], convert(data[3])));
		}
		Collections.sort(list);

		for (MusicInfo musicInfo : list) {
			if (musicInfo.checkLoop(m)) {
				return musicInfo.getTitle();
			}
		}
		return "(None)";
	}

	private String convert(String m) {
		return m
			.replace("C#", "c")
			.replace("D#", "d")
			.replace("F#", "f")
			.replace("G#", "g")
			.replace("A#", "a");
	}

	class MusicInfo implements Comparable<MusicInfo> {
		private Date start;
		private Date end;
		private String title;
		private String loop;

		public String getTitle() {
			return title;
		}

		public MusicInfo(String start, String end, String title, String loop) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm");
			this.start = format.parse(start);
			this.end = format.parse(end);
			this.title = title;
			int length = getDuration();
			int repeat = length / loop.length() + 1;
			if (length < loop.length()) {
				this.loop = loop.substring(0, length);
			} else {
				while (repeat-- > 0) {
					this.loop = this.loop + loop;
				}
			}
		}

		public int getDuration() {
			return (int)((this.end.getTime() - this.start.getTime()) / 1000L / 60L);
		}

		public boolean checkLoop(String m) {
			return loop.contains(m);
		}

		@Override
		public int compareTo(MusicInfo o) {
			return o.getDuration() - this.getDuration();
		}
	}
}