package net.euler.problemNo35;

import java.util.Date;

public class Euler35 {
	public static boolean primeRotataions(int n) {
		if (!isPrime(n))
			return false;
		String rot = Integer.toString(n);
		if (rot.contains("0") || rot.contains("2") || rot.contains("4") || rot.contains("6") || rot.contains("8")) {
			return false;
		}
		for (int i = 0; i < rot.length(); i++) {
			rot = rot.substring(1) + rot.charAt(0);
			if (!isPrime(Integer.parseInt(rot)))
				return false;
		}
		return true;
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++)
			if (num % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		int total = 13;
		Date time = new Date();
		for (int i = 101; i < 1000000; i += 2)
			if (primeRotataions(i))
				total++;
		System.out.println(total);
		System.out.println(new Date().getTime() - time.getTime());
	}
}