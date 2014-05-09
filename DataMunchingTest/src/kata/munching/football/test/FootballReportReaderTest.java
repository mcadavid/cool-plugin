package kata.munching.football.test;

import static org.junit.Assert.assertEquals;
import kata.munching.football.FootballReportItem;
import kata.munching.football.FootballReportReader;

import org.junit.Test;

public class FootballReportReaderTest {

	@Test
	public void testCreateReportItem() {
		String teamName = "MyTeam";
		String[] array = { "1", teamName, "1", "1", "1", "1", "1", "1", "1", "1", "1" };
		FootballReportItem item = new FootballReportItem(1, 1, 1, teamName);
		assertEquals(item, new FootballReportReader().createReportItem(array));
	}

}
