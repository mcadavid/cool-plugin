package kata.munching.football.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import kata.munching.football.FootballReportReader;
import kata.munching.football.FootballSmallestSpreadReport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FussballSmallestScoreSpreadReportTest {

	private String expectedString;
	private String fileName;

	public FussballSmallestScoreSpreadReportTest(String expectedString, String fileName) {
		super();
		this.expectedString = expectedString;
		this.fileName = fileName;
	}

	@Parameters(name = "{index}: FussballSmallestScoreSpreadReportTest({1}->{0})")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { null, null },//
				{ null, "src/test-data/weather/empty.dat" },//
				{ "Arsenal", "src/test-data/football/football_1.dat" }, //
				{ "Liverpool", "src/test-data/football/football_2.dat" },//
				{ "Leicester", "src/test-data/football/football.dat" },//
		});

	}

	@Test
	public void test() throws IOException {
		assertEquals(expectedString, new FootballSmallestSpreadReport().printSmallestSpread(fileName, new FootballReportReader()));
	}
}
