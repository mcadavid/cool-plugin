package net.eulerproject.problemNo11;

public class MaximalProductOfNthFollowingNumberInAnMxMGrid {

	int[][] matrix = null;
	int rowLength = 0;
	int maxProduct = 1;
	public int nrOfPossibilitiesHorizontal = 0;
	public int nrOfPossibilitiesVertical = 0;
	public int nrOfPossibilitiesDiagonalLeft = 0;
	public int nrOfPossibilitiesDiagonalRight = 0;

	public int calculateMaximalProduct(int rowLength, int[][] matrix) {
		this.rowLength = rowLength;
		this.matrix = matrix;

		System.out.println("\n=====Horizontal=========");
		horizontalMaximalProduct();
		System.out.println("Current Max Product = " + maxProduct);
		System.out.println("\n=====Vertical=========");
		verticalMaximalProduct();
		System.out.println("Current Max Product = " + maxProduct);
		System.out.println("\n======Diagonal Left========");
		diagonalLeftMaximalProduct();
		System.out.println("Current Max Product = " + maxProduct);
		System.out.println("\n=======Diagonal Right=======");
		diagonalRightMaximalProduct();
		System.out.println("Current Max Product = " + maxProduct);
		System.out.println("\n==============");

		return maxProduct;
	}

	/**
	 * @return
	 */
	private void horizontalMaximalProduct() {

		for (int i = 0; i < matrix.length; i++) {

			int bound = rowLength;
			for (int j = 0; j < matrix.length - rowLength + 1; j++) {

				int rowCounter = j;
				int product = 1;

				while (rowCounter < bound) {

					int current_i = matrix[i][rowCounter];

					System.out.print(current_i + " ");

					product = current_i * product;

					rowCounter++;
				}
				nrOfPossibilitiesHorizontal++;

				System.out.println();
				if (product > maxProduct) {
					maxProduct = product;

				}
				bound++;
			}

		}

	}

	/**
	 * @return
	 */
	private void verticalMaximalProduct() {

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix.length - rowLength + 1; j++) {

				int rowCounter = j;
				int product = 1;
				for (int k = 0; k < rowLength; k++) {

					int current_i = matrix[rowCounter][i];
					System.out.print(current_i + " ");
					product = current_i * product;
					rowCounter++;

					if (rowCounter >= matrix.length) {
						break;
					}

				}
				nrOfPossibilitiesVertical++;

				System.out.println();
				if (product > maxProduct) {
					maxProduct = product;

				}

			}

		}

	}

	/**
	 * @return
	 */
	private void diagonalRightMaximalProduct() {

		for (int i = 0; i < matrix.length - rowLength + 1; i++) {

			for (int j = 0; j <= matrix.length - rowLength; j++) {

				int rowCounter = i;
				int columnCounter = j;
				int product = 1;

				for (int k = 0; k < rowLength; k++) {

					int current_i = matrix[rowCounter++][columnCounter++];
					System.out.print(current_i + " ");
					product = current_i * product;

					if (columnCounter >= matrix.length || rowCounter >= matrix.length) {
						break;
					}
				}
				nrOfPossibilitiesDiagonalRight++;

				System.out.println();
				if (product > maxProduct) {
					maxProduct = product;
				}

			}
		}

	}

	/**
	 * @return
	 */
	private void diagonalLeftMaximalProduct() {

		for (int i = 0; i < matrix.length - rowLength + 1; i++) {

			for (int j = rowLength - 1; j < matrix.length; j++) {

				int rowCounter = i;
				int columnCounter = j;
				int product = 1;
				for (int k = 0; k < rowLength; k++) {

					int current_i = matrix[rowCounter++][columnCounter--];
					System.out.print(current_i + " ");
					product = current_i * product;

					if (columnCounter < 0 || rowCounter >= matrix.length) {
						break;
					}
				}
				nrOfPossibilitiesDiagonalLeft++;

				System.out.println();
				if (product > maxProduct) {
					maxProduct = product;

				}

			}

		}

	}
}
