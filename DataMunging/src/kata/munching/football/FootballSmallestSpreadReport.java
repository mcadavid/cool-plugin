package kata.munching.football;

import kata.munching.ReportItem;
import kata.munching.SmallestSpreadReport;

public class FootballSmallestSpreadReport extends SmallestSpreadReport {

	@Override
	public String getPrintString(ReportItem item) {
		if (item instanceof FootballReportItem) {
			return ((FootballReportItem) item).getTeamName();
		}
		return null;
	}

}
