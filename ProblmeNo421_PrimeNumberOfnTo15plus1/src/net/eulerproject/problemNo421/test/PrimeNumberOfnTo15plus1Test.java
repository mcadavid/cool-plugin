package net.eulerproject.problemNo421.test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo421.PrimeNumberOfnTo15plus1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class PrimeNumberOfnTo15plus1Test {

	private BigInteger result;
	private BigInteger ns;
	private BigInteger ms;

	@Parameters
	public static Collection<Object[]> data() throws IOException {

		Object[][] cases = {
				// { new BigInteger("2"), new BigInteger("10"), new
				// BigInteger("5") },
				{ new BigInteger("2"), new BigInteger("1000"), new BigInteger("347") },
				// { new BigInteger("1000"), new BigInteger("100000000"), new
				// BigInteger("1518081888") } };
				{ new BigInteger("10"), new BigInteger("100000000"), new BigInteger("8543204") } };

		return Arrays.asList(cases);
	}

	@Test
	public void test() {
		System.out.println("******");
		BigInteger calculatedResult = new PrimeNumberOfnTo15plus1(ms, ns).calculateSum();
		// assertEquals(result, calculatedResult);
	}

	public PrimeNumberOfnTo15plus1Test(BigInteger ms, BigInteger ns, BigInteger result) {
		super();
		this.ms = ms;
		this.ns = ns;
		this.result = result;
	}
}
