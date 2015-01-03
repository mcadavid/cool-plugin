package net.eulerproject.problemNo12;

public class TriangleNumberDivisorCalculator {

	public int numberOfTheNthTriangleNumberDivisors(final int nth) {

		int triangleNumber = calculateTriangleNumber(nth);
		System.out.print(triangleNumber);

		int numberOfDivisors = calculateNumberOfDivisors(triangleNumber);
		return numberOfDivisors;
	}

	private int calculateNumberOfDivisors(int triangleNumber) {
		int numberOfDivisors = 1;
		for (int i = 2; i <= triangleNumber; i++) {
			if (triangleNumber % i == 0) {
				numberOfDivisors++;
			}
		}
		return numberOfDivisors;
	}

	private int calculateTriangleNumber(final int nth) {
		return nth * (nth + 1) / 2;
	}

	public int firstTriangleNumberWithNumberOfDivisorsEqual(int numberOfDivisorsLimit, int startingCounter) {

		int counter = startingCounter;

		while (true) {

			System.out.print("The " + counter + "-th number ");
			int nrOfDivisors = numberOfTheNthTriangleNumberDivisors(counter++);
			System.out.println(" has " + nrOfDivisors + " divisors");
			if (nrOfDivisors >= numberOfDivisorsLimit) {
				System.out.print(nrOfDivisors - 1 + " ");
				break;
			}
		}

		System.out.print(counter - 1 + " ");
		return calculateTriangleNumber(counter - 1);
	}

	public int firstTriangleNumberWithNumberOfDivisorsEqual(int numberOfDivisorsLimit) {

		return firstTriangleNumberWithNumberOfDivisorsEqual(numberOfDivisorsLimit, 1);
	}

}
