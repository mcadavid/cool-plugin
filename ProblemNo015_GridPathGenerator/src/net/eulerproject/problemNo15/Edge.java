package net.eulerproject.problemNo15;

public enum Edge {

	RIGHT(1, 0), DOWN(0, 1);

	int x, y;

	private Edge(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
