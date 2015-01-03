package net.eulerproject.problemNo13;

import java.math.BigInteger;

public class FirstDigitsOfSumOfLargeNumbers {

	BigInteger sumOfAll;

	public FirstDigitsOfSumOfLargeNumbers(Integer numberofInteger, String... numbersToAdd) {

		for (int i = 0; i < numbersToAdd.length; i++) {
			BigInteger correspondingNumber = new BigInteger(numbersToAdd[i]);
			sumOfAll = sumOfAll != null ? sumOfAll.add(correspondingNumber) : correspondingNumber;

		}
	}

	public String calculateFirstDigitsOfSum(Integer numberofInteger) {
		return sumOfAll.toString().substring(0, numberofInteger);
	}

}
