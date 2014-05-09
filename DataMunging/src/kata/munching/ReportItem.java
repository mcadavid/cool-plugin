package kata.munching;

public class ReportItem implements Comparable<ReportItem> {

	private int id;
	private int value1;
	private int value2;

	public ReportItem(int day, int v1, int v2) {
		super();
		this.id = day;
		this.value1 = v1;
		this.value2 = v2;
	}

	@Override
	public int compareTo(ReportItem o) {
		if (o == null) {
			return 1;
		}
		if (getValue1() - getValue2() < o.getValue1() - o.getValue2()) {
			return -1;
		} else if (getValue1() - getValue2() == o.getValue1() - o.getValue2()) {
			if (getId() < o.getId()) {
				return -1;
			} else if (getId() == o.getId()) {
				return 0;
			}
			return 1;
		}
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		ReportItem d = (ReportItem) obj;
		if (d.getId() == id && d.getValue1() == value1 && d.getValue2() == value2) {
			return true;
		}
		return false;
	}

	public int getId() {
		return id;
	}

	public int getValue1() {
		return value1;
	}

	public int getValue2() {
		return value2;
	}

}
