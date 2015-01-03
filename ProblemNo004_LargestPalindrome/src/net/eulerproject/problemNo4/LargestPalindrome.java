package net.eulerproject.problemNo4;

import net.eulerproject.utils.PalindromeNumbersUtils;

public class LargestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// dummy approach
		int maximum = 0;
		int counter = 0;
		// multiply the 3-digits number in growing sequence
		for (int i = 100; i < 999; i++) {
			for (int j = i; j < 999; j++) {

				int prod = i*j;
				
				// check if product is palindrome
				if (PalindromeNumbersUtils.isPalindrome(prod)) {
					// replace with the current palindrome
					System.out.println(i + " * " + j + " = " + prod);
					if (maximum < prod) {
						maximum = prod;
					}
					counter++;
				}
			}

		}
		System.out.println("of all "+counter +" palindromes, "+maximum +" is the biggest");

	}

}
