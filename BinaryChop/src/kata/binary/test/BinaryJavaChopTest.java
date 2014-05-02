package kata.binary.test;

import kata.binary.BinaryJavaChop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryJavaChopTest extends AbstractBinaryChopTest {

	public BinaryJavaChopTest(int[] source, int what, int index) {
		super(source, what, index);
	}

	@Test
	public void test() {
		Assert.assertEquals(expectedIndex, new BinaryJavaChop().chop(value, source));
	}

}
