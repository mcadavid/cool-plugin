package kata.binary.test;

import static org.junit.Assert.assertEquals;
import kata.binary.BinaryChopRecursiveUsingOrder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryChopRecursiveUsingOrderTest extends AbstractBinaryChopTest {

	public BinaryChopRecursiveUsingOrderTest(int[] source, int value, int expectedIndex) {
		super(source, value, expectedIndex);
	}

	@Test
	public void test() {
		assertEquals(expectedIndex, new BinaryChopRecursiveUsingOrder().chop(value, source));
	}
}
