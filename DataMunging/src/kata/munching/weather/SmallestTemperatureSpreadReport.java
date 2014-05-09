package kata.munching.weather;

import kata.munching.ReportItem;
import kata.munching.SmallestSpreadReport;

public class SmallestTemperatureSpreadReport extends SmallestSpreadReport {

	@Override
	protected String getPrintString(ReportItem item) {
		return item.getId() + " " + item.getValue1() + " " + item.getValue2();

	}

}
