package kata.munching;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractReportReader {

	protected ArrayList<Integer> days = new ArrayList<Integer>();

	public ReportItem[] readReport(String fileName) throws IOException {
		if (fileName == null) {
			return null;
		}
		List<String> lines = readFile(fileName);
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

	private List<String> readFile(String fileName) throws IOException {
		Path file = Paths.get(fileName);
		Charset charset = Charset.forName("US-ASCII");
		ArrayList<String> lines = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException x) {
			throw x;
		}
		return lines;
	}
}
