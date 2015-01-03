package net.eulerproject.problemNo9.test;

import net.eulerproject.problemNo9.PythagoreanTriple;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PythagoreanTripleTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("--");
	}

	@Test
	public void testCalculate() {
		PythagoreanTriple triple =  new PythagoreanTriple();
		triple.calculate(12);
		assertEquals(3, triple.a);
		assertEquals(4, triple.b);
		assertEquals(5, triple.c);
		
		assertTrue(triple.a + triple.b + triple.c == 12);
		assertTrue(triple.isPythagorean());
	}
	
	@Test
	public void testCalculate_2() {
		PythagoreanTriple triple =  new PythagoreanTriple();
		triple.calculate(24);
		assertEquals(6, triple.a);
		assertEquals(8, triple.b);
		assertEquals(10, triple.c);
		
		assertTrue(triple.isPythagorean());
		
	}
	
	@Test
	public void testCalculate_3() {
		PythagoreanTriple triple =  new PythagoreanTriple();
		
		triple.calculate(1000);
		
		assertTrue(triple.isPythagorean());
		
		System.out.println(triple.a*triple.b*triple.c);
		
	}

}
