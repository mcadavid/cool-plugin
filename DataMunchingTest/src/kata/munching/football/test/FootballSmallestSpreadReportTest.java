package kata.munching.football.test;

import static org.junit.Assert.assertEquals;
import kata.munching.football.FootballReportItem;
import kata.munching.football.FootballSmallestSpreadReport;

import org.junit.Test;

public class FootballSmallestSpreadReportTest {

	@Test
	public void testGetPrintString() {
		String expected = "MyTeam";
		FootballReportItem item = new FootballReportItem(0, 0, 0, expected);
		assertEquals(expected, new FootballSmallestSpreadReport().getPrintString(item));
	}

}
