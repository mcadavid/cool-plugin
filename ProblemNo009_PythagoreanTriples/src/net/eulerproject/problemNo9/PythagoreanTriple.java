package net.eulerproject.problemNo9;

public class PythagoreanTriple {

	public int a, b, c = 0;

	public void calculate(int sum) {
		for (int i = 1; i < sum; i++) {

			for (int j = i; j <  sum - i - j; j++) {

				if (isPythagorean(i, j, sum - i - j)) {
					a = i;
					b = j;
					c = sum - i - j;
					break;
				}
			}
		}

		System.out.println("(" + a + "," + b + "," + c + ")");
	}

	private boolean isPythagorean(int... a) {
		if (a[0] * a[0] + a[1] * a[1] == a[2] * a[2])
			return true;
		else
			return false;
	}
	
	public boolean isPythagorean() {
		return isPythagorean(a,b,c);
		
	}

}
