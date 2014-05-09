package kata.munching.football;

import kata.munching.ReportItem;

public class FootballReportItem extends ReportItem {

	private String teamName;

	public FootballReportItem(int day, int v1, int v2, String teamName) {
		super(day, v1, v2);
		this.setTeamName(teamName);
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			FootballReportItem item = (FootballReportItem) obj;
			if (item.getTeamName().equals(teamName)) {
				return true;
			}
		}
		return false;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}
