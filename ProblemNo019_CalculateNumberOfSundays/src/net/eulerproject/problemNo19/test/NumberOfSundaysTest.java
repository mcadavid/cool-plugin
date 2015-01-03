package net.eulerproject.problemNo19.test;

import junit.framework.Assert;
import net.eulerproject.problemNo19.NumberOfSundays;

import org.junit.Test;

public class NumberOfSundaysTest {

	@Test
	public void test() {
		Assert.assertEquals(171, new NumberOfSundays(1900, 2000).calculate());
	}

}
