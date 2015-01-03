package net.eulerproject.problemNo15;

import java.math.BigInteger;

public class GridPathGenerator {

	private long totalPathNumber;
	private long gridSize;

	public long countPaths(long gridSize) {

		this.gridSize = gridSize;

		// addNextStep(new GridPath(gridSize), Edge.RIGHT, 0);
		totalPathNumber = calculate(gridSize);

		return totalPathNumber;

	}

	private void addNextStep(GridPath p, Edge e, int counter) {

		if (counter == 2 * gridSize - 1 || p.isVerticalBorderReached() || p.isHorizontalBorderReached()) {
			System.out.println(p);
			totalPathNumber++;
		} else {
			p.add(counter, e);
			counter++;

			addNextStep(p, Edge.RIGHT, counter);

			addNextStep(p, Edge.DOWN, counter);

			counter--;
			p.remove(counter);

		}

	}

	private long calculate(long n) {
		BigInteger fact2n = BigInteger.valueOf(1l);
		for (long i = n + 1; i <= 2 * n; i++) {
			fact2n = fact2n.multiply(BigInteger.valueOf(i));
		}

		long factn = factorial(n);

		System.out.println(fact2n);
		System.out.println(factn);

		return fact2n.divide(BigInteger.valueOf(factn)).longValue();

	}

	public long factorial(long n) {
		if (n < 0)
			throw new RuntimeException("Underflow error in factorial");
		else if (n > 20)
			throw new RuntimeException("Overflow error in factorial");
		else if (n == 0)
			return 1;
		else
			return n * factorial(n - 1);
	}

}
