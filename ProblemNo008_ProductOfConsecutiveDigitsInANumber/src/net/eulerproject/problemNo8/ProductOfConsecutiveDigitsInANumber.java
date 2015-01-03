package net.eulerproject.problemNo8;

public class ProductOfConsecutiveDigitsInANumber {

	public int maxProductOfConsecutiveNumbers(String number, int productLength) {

		char[] numberAsChar = number.toCharArray();

		int maxProduct = 1;
		for (int cursor = 0; cursor < numberAsChar.length - productLength + 1; cursor++) {

			int product = 1;

			for (int i = cursor; i < productLength + cursor; i++) {

				int nextInteger = new Integer(numberAsChar[i] + "");

				product = nextInteger * product;

			}

			// new maximal value
			if (product > maxProduct) {
				maxProduct = product;
			}

		}

		return maxProduct;
	}
}
