package kata.binary.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BinaryChopIterativeTest.class, BinaryChopRecursiveTest.class, BinaryChopRecursiveTestFirstTry.class, BinaryChopRecursiveUsingOrderTest.class, BinaryJavaChopTest.class,
		BinaryNewListsIterativeChopTest.class })
public class AllTests {

}
