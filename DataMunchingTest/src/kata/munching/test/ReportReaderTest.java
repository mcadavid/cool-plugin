package kata.munching.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import kata.munching.ReportItem;
import kata.munching.weather.WeatherReportReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ReportReaderTest {

	private String fileName;
	private ReportItem expectedDayReport[];

	public ReportReaderTest(String fileName, ReportItem[] expectedDayReport) {
		super();
		this.fileName = fileName;
		this.expectedDayReport = expectedDayReport;
	}

	@Parameters(name = "{index}: report({0})")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { null, null },//
				{ "src/test-data/weather/report1.dat", new ReportItem[] { new ReportItem(1, 15, 7) } }, //
				{ "src/test-data/weather/report2.dat", new ReportItem[] { new ReportItem(1, 12, 7) } },//
				{ "src/test-data/weather/report3.dat", new ReportItem[] { new ReportItem(1, 15, 7) } }, //
				{ "src/test-data/weather/report4.dat", new ReportItem[] { new ReportItem(1, 12, 7), new ReportItem(2, 14, 7), new ReportItem(3, 28, 26) } },//
				{ "src/test-data/weather/report5.dat", new ReportItem[] { new ReportItem(1, 12, 7), new ReportItem(2, 14, 7), new ReportItem(4, 18, 16), new ReportItem(3, 28, 26) } } //

				});

	}

	@Test
	public void test() throws IOException {
		if (fileName == null) {
			assertNull(new WeatherReportReader().readReport(null));
			return;
		}
		List<ReportItem> readReportList = Arrays.asList(new WeatherReportReader().readReport(fileName));

		for (ReportItem day : expectedDayReport) {
			assertNotNull(readReportList);
			assertTrue(readReportList.contains(day));
		}

		List<ReportItem> expectedList = Arrays.asList(expectedDayReport);
		for (ReportItem day : readReportList) {
			assertTrue(expectedList.contains(day));
		}
	}

}
