package net.euler.problemNo36;

import org.junit.Before;
import org.junit.Test;

public class DoublePalindromFinderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("The result is " + new DoublePalindromFinder().sumAllDoublePalindrome(1000000));
	}

}
