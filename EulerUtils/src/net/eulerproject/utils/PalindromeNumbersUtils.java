package net.eulerproject.utils;

public class PalindromeNumbersUtils {

	public static boolean isPalindrome(int number) {
	
		if (number % 11 != 0){
			return false;
		}
		int firstPart = number / 1000;
		int secondPart = number % 1000;
	
		// second part is of the form: 100*a2 + 10*a1 +a0
		int a0 = secondPart % 10;
		int a2 = secondPart / 100;
	
		// = a0 * 100 + a2 + secondPart - 100* a2 - a0
		int inversedSecondPart = 99 * a0 - 99 * a2 + secondPart;
	
		if (inversedSecondPart == firstPart) {
			return true;
		}
		return false;
	}

	

}
