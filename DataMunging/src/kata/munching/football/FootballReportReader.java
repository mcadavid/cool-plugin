package kata.munching.football;

import kata.munching.AbstractReportReader;
import kata.munching.ReportItem;

public class FootballReportReader extends AbstractReportReader {

	@Override
	public ReportItem createReportItem(String[] words) {
		if (words.length > 8 && words[0] != null && words[1] != null && words[6] != null && words[7] != null) {
			try {
				int day = new Integer(words[0]);

				if (!days.contains(Integer.valueOf(day))) {
					days.add(day);
					return new FootballReportItem(new Integer(words[0]), new Integer(words[6]), new Integer(words[7]), words[1]);
				}
			} catch (RuntimeException e) {
				// do nothing
			}
		}
		return null;
	}
}
