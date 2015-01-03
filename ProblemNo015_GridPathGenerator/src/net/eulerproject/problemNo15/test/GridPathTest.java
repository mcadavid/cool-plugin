package net.eulerproject.problemNo15.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import net.eulerproject.problemNo15.Edge;
import net.eulerproject.problemNo15.GridPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class GridPathTest {

	private GridPath path;
	private Boolean resultForVertical;
	private Boolean resultForHorizontal;

	@Parameters
	public static Collection<Object[]> dataForCollatzSeries() {

		Object[][] cases = { { createDDPath(), false, true }, { createRRPath(), true, false }, { createDRPath(), false, false },
				{ createRDPath(), false, false } };

		return Arrays.asList(cases);

	}

	public GridPathTest(GridPath path, Boolean resultForVertical, Boolean resultForHorizontal) {
		this.path = path;
		this.resultForVertical = resultForVertical;
		this.resultForHorizontal = resultForHorizontal;

	}

	@Test
	public void testIsHorizontalBorderReachedWhenRR() {

		assertEquals(resultForHorizontal, this.path.isHorizontalBorderReached());
	}

	@Test
	public void testIsVerticalBorderReachedWhenRDPath() {

		assertEquals(resultForVertical, this.path.isVerticalBorderReached());
	}

	private static GridPath createRRPath() {
		GridPath path = new GridPath(2);
		path.add(Edge.RIGHT);
		path.add(Edge.RIGHT);
		return path;
	}

	private static GridPath createDDPath() {
		GridPath path = new GridPath(2);
		path.add(Edge.DOWN);
		path.add(Edge.DOWN);
		return path;
	}

	private static GridPath createDRPath() {
		GridPath path = new GridPath(2);
		path.add(Edge.DOWN);
		path.add(Edge.RIGHT);
		return path;
	}

	private static GridPath createRDPath() {
		GridPath path = new GridPath(2);
		path.add(Edge.DOWN);
		path.add(Edge.RIGHT);
		return path;
	}

}
