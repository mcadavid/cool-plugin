package kata.binary.test;

import static org.junit.Assert.assertEquals;
import kata.binary.BinaryIterativeChop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BinaryChopIterativeTest extends AbstractBinaryChopTest {

	public BinaryChopIterativeTest(int[] source, int what, int index) {
		super(source, what, index);
	}

	@Test
	public void test() {
		assertEquals(expectedIndex, new BinaryIterativeChop().chop(what, source));
	}

}
