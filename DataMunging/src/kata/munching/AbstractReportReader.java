package kata.munching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kata.utilities.FileUtilities;

public abstract class AbstractReportReader {

	protected ArrayList<Integer> days = new ArrayList<Integer>();

	public ReportItem[] readReport(String fileName) throws IOException {
		if (fileName == null) {
			return null;
		}
		List<String> lines = FileUtilities.readLines(fileName);
		List<ReportItem> completeReport = new ArrayList<>();
		for (String l : lines) {
			ReportItem report = createReportItem(l.trim().split("\\W+"));
			if (report != null) {
				completeReport.add(report);
			}
		}
		return completeReport.toArray(new ReportItem[0]);
	}

	protected abstract ReportItem createReportItem(String[] words);

}
