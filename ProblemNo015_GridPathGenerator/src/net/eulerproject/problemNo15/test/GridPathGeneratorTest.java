package net.eulerproject.problemNo15.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo15.GridPathGenerator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GridPathGeneratorTest {

	private Long numberOfPaths;
	private Long gridSize;

	@Parameters
	public static Collection<Object[]> dataForPaths() {

		Object[][] cases = { { 2l, 6l }, { 3l, 20l }, { 4l, 70l }, { 5l, 252l }, { 10l, 184756l }, { 20l, 137846528820l } };

		return Arrays.asList(cases);

	}

	public GridPathGeneratorTest(Long gridSize, Long numberOfPaths) {
		this.gridSize = gridSize;
		this.numberOfPaths = numberOfPaths;

	}

	@Test
	public void testGeneratePaths() {

		long numberOfPathsOfAGrid = new GridPathGenerator().countPaths(gridSize);
		assertEquals(numberOfPaths, Long.valueOf(numberOfPathsOfAGrid));
		System.out.println();
	}

}
