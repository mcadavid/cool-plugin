package net.eulerproject.problemNo14;

public class OddStep {

	long stepNumber;

	public OddStep(long step) {
		this.stepNumber = step;
	}

	public long calculate() {
		return 3 * this.stepNumber + 1;
	}
}
