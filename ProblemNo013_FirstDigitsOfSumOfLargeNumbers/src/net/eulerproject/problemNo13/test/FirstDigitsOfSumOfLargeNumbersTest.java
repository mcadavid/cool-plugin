package net.eulerproject.problemNo13.test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo13.FirstDigitsOfSumOfLargeNumbers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class FirstDigitsOfSumOfLargeNumbersTest {

	String[] numbersToAdd;
	Integer numberofInteger;
	String expectedValue;

	public FirstDigitsOfSumOfLargeNumbersTest(String expectedValue, Integer numberOfFirstInteger, String... numbersToAdd) {
		this.numbersToAdd = numbersToAdd;
		this.numberofInteger = numberOfFirstInteger;
		this.expectedValue = expectedValue;

	}

	@Parameters
	public static Collection<Object[]> dataForNumberOfDivisors() throws IOException {

		Object[] values = { "40", new Integer(2), new String[] { "10", "10", "10", "10" } };

		Object[] values2 = { "40", new Integer(2), new String[] { "100", "100", "100", "100" } };

		Object[] values3 = { "252", new Integer(3), new String[] { "121", "4", "8", "2389" } };

		Object[] values4 = { "252", new Integer(3), parseEntry(2) };

		Object[] values5 = { "5537376230", new Integer(10), parseEntry(1) };

		Object[][] cases = { values, values2, values3, values4, values5 };

		return Arrays.asList(cases);
	}

	@Test
	public void testFirstDigitsOfSum() {

		FirstDigitsOfSumOfLargeNumbers calculator = new FirstDigitsOfSumOfLargeNumbers(numberofInteger, numbersToAdd);
		String firstDigits = calculator.calculateFirstDigitsOfSum(numberofInteger);

		assertEquals("Wrong serial of digits", expectedValue, firstDigits);
	}

	static String[] parseEntry(int fileNumber) throws IOException {

		FileReader fr = new FileReader("src/inputEuler" + fileNumber);
		BufferedReader br = new BufferedReader(fr);
		Collection<String> fileAsString = new ArrayList<String>();
		String s;
		while ((s = br.readLine()) != null) {
			fileAsString.add(s);
		}
		fr.close();

		return fileAsString.toArray(new String[0]);
	}
}
