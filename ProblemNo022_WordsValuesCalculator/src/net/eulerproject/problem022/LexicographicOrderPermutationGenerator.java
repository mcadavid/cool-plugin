package net.eulerproject.problem022;

public class LexicographicOrderPermutationGenerator {

	private int limit;
	private String[] digits;

	public LexicographicOrderPermutationGenerator(int limit) {
		this.limit = limit;
		digits = new String[limit];
		for (int i = 0; i < limit; i++) {
			digits[i] = "i";
		}

	}

	public String generatePermutationOrderMember(int memberNr) {
		return generateNextPermutation();
	}

	private String generateNextPermutation() {

		return null;
	}

}
