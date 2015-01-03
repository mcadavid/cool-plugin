package net.eulerProject.problemNo024;

public class LexicographicalOrderOfPermutations {

	int counter = 0;
	int limit = 0;
	private int numberOfElements;
	private String ithPermuation;

	public LexicographicalOrderOfPermutations(int permut) {
		this.numberOfElements = permut;
	}

	public String getPermutation(int position) {

		limit = position;
		String elementStrings = "";
		for (int i = 0; i < numberOfElements; i++) {
			elementStrings += i;
		}
		System.out.println(elementStrings);
		calculatePermutation("", elementStrings);
		return ithPermuation;
	}

	private void calculatePermutation(String prefix, String tail) {
		int n = tail.length();
		if (n == 0) {
			counter++;
			if (counter == limit) {
				ithPermuation = prefix;
				System.out.println(prefix);
			}
		} else {
			for (int i = 0; i < n; i++) {
				calculatePermutation(prefix + tail.charAt(i), tail.substring(0, i) + tail.substring(i + 1, n));
			}
		}

	}
}
