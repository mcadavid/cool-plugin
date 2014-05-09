package kata.munching.test;

import kata.munching.football.test.FootballReportReaderTest;
import kata.munching.football.test.FootballSmallestSpreadReportTest;
import kata.munching.football.test.FussballSmallestScoreSpreadReportTest;
import kata.munching.weather.test.SmallestTemperatureSpreadReportTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FootballReportReaderTest.class, FootballSmallestSpreadReportTest.class, ReportReaderTest.class, FussballSmallestScoreSpreadReportTest.class, SmallestTemperatureSpreadReportTest.class })
public class AllTests {

}
