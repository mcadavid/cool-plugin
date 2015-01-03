package net.eulerproject.problemNo15;

import java.util.ArrayList;

/**
 * A path is a set of edges left or down leading the south,east corner
 * 
 * @author FC020803
 * 
 */
public class GridPath extends ArrayList<Edge> {

	private int gridSize;
	private int correctCounterX;
	private int correctCounterY;

	public GridPath(int gridSize) {
		this.gridSize = gridSize;
	}

	public boolean isPath() {
		int sumX = 0, sumY = 0;
		for (Edge anEdge : this) {
			sumX += anEdge.x;
			sumY += anEdge.y;
		}
		// sum all the xs and the ys has to be the same as the grid
		if (sumX == gridSize && sumY == gridSize) {
			return true;
		}
		throw new IllegalStateException();

	}

	public boolean isHorizontalBorderReached() {
		int sumY = 0;
		for (Edge anEdge : this) {
			sumY += anEdge.y;

		}
		// sum all the xs and the ys has to be the same as the grid
		if (sumY == gridSize) {
			return true;
		}
		return false;
	}

	public boolean isVerticalBorderReached() {
		int sumX = 0;
		for (Edge anEdge : this) {
			sumX += anEdge.x;

		}
		// sum all the xs and the ys has to be the same as the grid
		if (sumX == gridSize) {
			return true;
		}
		return false;
	}

	public boolean isEquals(GridPath path) {
		for (int i = 0; i < size(); i++) {
			if (!path.get(i).equals(get(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean add(Edge e) {

		correctCounterX = e.x;
		correctCounterY = e.y;

		if (correctCounterX > gridSize || correctCounterY > gridSize) {
			throw new IllegalArgumentException();
		}

		super.add(e);
		return true;
	}

}
