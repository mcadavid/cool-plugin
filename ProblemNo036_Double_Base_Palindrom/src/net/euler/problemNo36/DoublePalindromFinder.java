package net.euler.problemNo36;

import java.util.Date;

public class DoublePalindromFinder {

	public int sumAllDoublePalindrome(int max) {
		Date date = new Date();
		int sum = 0;
		for (int i = 1; i < max; i = i + 2) {
			if (is10Palindrom(i) && is2Palindrom(i)) {
				sum += i;
			}
		}
		System.out.println(new Date().getTime() - date.getTime());
		return sum;
	}

	private boolean is10Palindrom(int i) {
		String iString = String.valueOf(i);
		return iString.equals(reverse(iString));
	}

	private boolean is2Palindrom(int i) {
		String iString = Integer.toString(i, 2);
		return iString.equals(reverse(iString));
	}

	private String reverse(String iString) {
		char[] stringAsArray = iString.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = stringAsArray.length - 1; i >= 0; i--) {
			builder.append(stringAsArray[i]);
		}
		return builder.toString();
	}

}
