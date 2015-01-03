package net.euler.problemNo028;

public class SumOfDiagonalsOfANumberSpiralCalculator {

	public int calculate(int spiralSize) {

		if (spiralSize % 2 == 0) {
			throw new SpiralNumberWrongEvenNumberSize();
		}
		if (spiralSize == 1) {
			return 1;
		} else {
			return 4 * spiralSize * spiralSize - 6 * spiralSize + 6 + calculate(spiralSize - 2);
		}
	}

}
