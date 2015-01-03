package net.eulerproject.problemNo14;

public class CollatzSeries {

	long startingPoint;
	public long length = 1;
	long nextStep = 0;

	public CollatzSeries(long startingPoint) {
		super();
		this.startingPoint = startingPoint;
		this.nextStep = startingPoint;
	}

	public void calculateLengthRecursive() {

		if (nextStep == 1) {
			return;
		} else {
			if (isEven()) {
				nextStep = new EvenStep(nextStep).calculate();
			} else {
				nextStep = new OddStep(nextStep).calculate();
			}
		}
		this.length++;

		calculateLengthRecursive();
	}

	private void calculateLength() {
		while (nextStep > 1) {
			if (isEven()) {
				nextStep = new EvenStep(nextStep).calculate();
			} else {
				nextStep = new OddStep(nextStep).calculate();
			}
			// System.out.printf(" -> %d", nextStep);
			this.length++;
		}
	}

	private boolean isEven() {
		return nextStep % 2 == 0;
	}

	public long calculate() {
		// System.out.printf("Collatz series for %d",
		// Integer.valueOf(startingPoint));
		calculateLength();
		// System.out.println();
		return length;
	}
}
