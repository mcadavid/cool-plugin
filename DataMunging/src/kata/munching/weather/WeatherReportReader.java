package kata.munching.weather;

import kata.munching.ReportItem;
import kata.munching.AbstractReportReader;

public class WeatherReportReader extends AbstractReportReader {

	protected ReportItem createReportItem(String[] words) {
		if (words.length > 3 && words[0] != null && words[1] != null && words[2] != null) {
			try {
				int day = new Integer(words[0]);
				int maxT = new Integer(words[1]);
				int minT = new Integer(words[2]);
				if (maxT < minT) {
					throw new RuntimeException();
				}
				if (!days.contains(Integer.valueOf(day))) {
					days.add(day);
					return new ReportItem(day, maxT, minT);
				}
			} catch (RuntimeException e) {
				// do nothing
			}
		}
		return null;
	}

}
