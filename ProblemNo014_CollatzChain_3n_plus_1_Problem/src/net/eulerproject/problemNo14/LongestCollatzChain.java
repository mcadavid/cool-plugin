package net.eulerproject.problemNo14;

public class LongestCollatzChain {

	long limit;
	long maximalLenght = 1;
	long longestStartingNumber = 1;

	public LongestCollatzChain(int limit) {
		this.limit = limit;
	}

	public long calculate() {

		for (int i = 1; i <= limit; i++) {

			long length = new CollatzSeries(i).calculate();

			if (length > maximalLenght) {
				maximalLenght = length;
				longestStartingNumber = i;
			}
		}

		System.out.printf("The longest chain (length %d) with a number smaller than %d is attained by %d", Long.valueOf(maximalLenght),
				Long.valueOf(limit), Long.valueOf(longestStartingNumber));
		System.out.println("\n");
		return longestStartingNumber;
	}
}
