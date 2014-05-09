package kata.munching.weather.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import kata.munching.weather.SmallestTemperatureSpreadReport;
import kata.munching.weather.WeatherReportReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SmallestTemperatureSpreadReportTest {

	private String expectedString;
	private String fileName;

	public SmallestTemperatureSpreadReportTest(String expectedString, String fileName) {
		super();
		this.expectedString = expectedString;
		this.fileName = fileName;
	}

	@Parameters(name = "{index}: ({1}->{0}):SmallestTemperatureSpreadReportTest")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] { { null, null },//
				{ null, "src/test-data/weather/empty.dat" },//
				{ "1 15 7", "src/test-data/weather/report1.dat" }, //
				{ "1 12 7", "src/test-data/weather/report2.dat" },//
				{ "1 15 7", "src/test-data/weather/report3.dat" }, //
				{ "3 28 26", "src/test-data/weather/report4.dat" },//
				{ "3 28 26", "src/test-data/weather/report5.dat" },//
				{ "14 61 59", "src/test-data/weather/weather.dat" } //
				});

	}

	@Test
	public void test() throws IOException {
		assertEquals(expectedString, new SmallestTemperatureSpreadReport().printSmallestSpread(fileName, new WeatherReportReader()));
	}

}
