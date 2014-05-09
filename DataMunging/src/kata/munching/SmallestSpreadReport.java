package kata.munching;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class SmallestSpreadReport {

	public String printSmallestSpread(String fileName, AbstractReportReader reader) throws IOException {

		ReportItem[] reports = reader.readReport(fileName);

		if (reports == null || reports.length == 0) {
			return null;
		}

		List<ReportItem> dayReports = Arrays.asList(reports);
		Collections.sort(dayReports);
		ReportItem firstDayReport = dayReports.get(0);

		return getPrintString(firstDayReport);

	}

	protected abstract String getPrintString(ReportItem item);

}
