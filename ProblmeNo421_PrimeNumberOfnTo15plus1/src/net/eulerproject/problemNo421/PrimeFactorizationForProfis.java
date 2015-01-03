package net.eulerproject.problemNo421;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.eulerproject.utils.PrimeNumbersUtils;

public class PrimeFactorizationForProfis {

	// static Vector factors = new Vector(); // Store factors
	static Set<BigInteger> factors = new HashSet<>();
	static final BigInteger TDLimit = BigInteger.valueOf(200000); // Trial
																	// division
																	// limit
	static final int RhoIter = 1000000; // Number of Monte Carlo iterations
	static byte buffer[] = new byte[100];
	static RandomAccessFile file;

	public static void main(String[] args) {
		String str = new String();
		System.out.println("Starting number");
		try {
			System.in.read(buffer);
			str = new String(buffer);
			String filename = new String(str.trim() + ".txt");
			file = new RandomAccessFile(filename, "rw");
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		BigInteger A = new BigInteger(str.trim());

		buffer = new byte[100];
		System.out.println("Starting index");
		try {
			System.in.read(buffer);
			str = new String(buffer);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		int index = Integer.parseInt(str.trim());

		Factor(A);
		for (BigInteger prime : factors) {
			System.out.println(prime + "-");
		}
		// display_factors(A);
		// while (A.compareTo(BigInteger.ONE) > 0) {
		// System.out.print(index + ". ");
		// try {
		// file.writeBytes(index + ". ");
		// } catch (IOException e) {
		// System.out.println(e.toString());
		// }
		// Factor(A);
		// display_factors(A);
		// BigInteger X = sum_factors(A);
		// A = X;
		// factors.removeAllElements();
		// index++;
		// }
	}

	public static Set<BigInteger> Factor(BigInteger A) // Highly dynamic piece
														// of code
	{

		BigInteger M = A; // M is the number to factor
		BigInteger p = BigInteger.ONE;
		BigInteger lastPrime = p;
		BigInteger TD = BigInteger.valueOf(3); // Start with 3 for new inputs
		String pf = new String(); // Initialize divisor string
		while (M.compareTo(BigInteger.ONE) > 0) {
			// Factoring Algorithms

			/**********************************************
			 * Trial Divide *
			 **********************************************/

			if (TD.compareTo(TDLimit) < 0) {
				p = trial_divide(M, TD); // Trial Divide
				if (p.remainder(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO) != 0) // Only
																						// if
																						// odd
				{
					TD = p; // Continue with divisor
				}
			}

			/**********************************************
			 * Test primality of cofactor *
			 **********************************************/

			if (TD.compareTo(TDLimit) > 0) {
				if (IsPrime(M) == true) {
					p = M;
				}
				while (IsPrime(M) == false && (IsPrime(p) == false || (M.remainder(p)).compareTo(BigInteger.ZERO) != 0)) {

					/**********************************************
					 * Pollard's Rho heuristic *
					 **********************************************/

					BigInteger out = Rho(M);
					if (out.compareTo(BigInteger.ONE) > 0) {
						p = out;
					}
					if (IsPrime(p) == true && (M.remainder(p)).compareTo(BigInteger.ZERO) == 0) {
						continue;
					}

					// buffer = new byte[100];
					// String C = new String();
					// System.out.println("Factor of " + M + ":");
					// try {
					// System.in.read(buffer);
					// C = new String(buffer);
					// } catch (IOException e) {
					// System.out.println(e.toString());
					// }
					// p = new BigInteger(C.trim());
					p = getFirstPrimeNumber(M, lastPrime);
					break;
				}
			}

			pf = p.toString(); // Divisor to string
			// factors.addElement(pf); // Push factor onto stack

			if (p.compareTo(new BigInteger("100000000")) > 0) {
				return factors;
			}

			lastPrime = p;
			factors.add(p);
			M = M.divide(p); // Dividend by divisor
		}
		return factors;
	}

	static java.math.BigInteger trial_divide(BigInteger A, BigInteger start) {
		if ((A.remainder(BigInteger.valueOf(2))).compareTo(BigInteger.ZERO) == 0) {
			return BigInteger.valueOf(2);
		}
		BigInteger B = start;
		while (B.compareTo(TDLimit) <= 0) {
			if ((A.remainder(B)).compareTo(BigInteger.ZERO) == 0) {
				return B;
			}
			B = B.add(BigInteger.valueOf(2));
		}
		return A;
	}

	// static void display_factors(BigInteger A) {
	// try {
	// int ptr;
	// int mul = 1;
	// System.out.print(A + " = ");
	// file.writeBytes(A + " = ");
	// for (ptr = 0; ptr < factors.size(); ptr++) {
	// if (ptr == factors.size() - 1 || ((factors.elementAt(ptr +
	// 1)).toString()).compareTo((factors.elementAt(ptr)).toString()) != 0) {
	// System.out.print(factors.elementAt(ptr));
	// file.writeBytes((factors.elementAt(ptr)).toString());
	// if (mul > 1) {
	// System.out.print("^" + mul);
	// file.writeBytes("^" + mul);
	// }
	// if (ptr != factors.size() - 1) {
	// System.out.print(" * ");
	// file.writeBytes(" * ");
	// } else {
	// System.out.println();
	// file.writeBytes("\n");
	// break;
	// }
	// mul = 1;
	// continue;
	// } else {
	// mul++;
	// continue;
	// }
	// }
	// } catch (IOException e) {
	// System.out.println(e.toString());
	// }
	// }

	// static java.math.BigInteger sum_factors(BigInteger A) {
	// int ptr;
	// BigInteger X = BigInteger.ONE;
	// BigInteger Y = BigInteger.ONE;
	// BigInteger Z = BigInteger.ONE;
	// for (ptr = 0; ptr < factors.size(); ptr++) {
	// BigInteger curr = new BigInteger((factors.elementAt(ptr)).toString());
	// if ((ptr == factors.size() - 1) || ((factors.elementAt(ptr +
	// 1)).toString()).compareTo((factors.elementAt(ptr)).toString()) != 0) {
	// Z = Z.multiply(curr);
	// Y = Y.add(Z);
	// X = X.multiply(Y);
	// Y = BigInteger.ONE;
	// Z = BigInteger.ONE;
	// if (ptr == factors.size() - 1) {
	// break;
	// }
	// } else {
	// Z = Z.multiply(curr);
	// Y = Y.add(Z);
	// continue;
	// }
	// }
	// return (X.subtract(A));
	// }

	private static BigInteger getFirstPrimeNumber(BigInteger A, BigInteger lastPrime) {
		List<BigInteger> primes = PrimeNumbersUtils.getListOfAllPrimeNumbers();

		int index = primes.indexOf(lastPrime);
		if (index < 0) {
			index = 0;
		}
		for (int i = index; i < primes.size(); i++) {
			if (A.mod(primes.get(i)).equals(BigInteger.ZERO)) {
				return primes.get(i);
			}
		}

		return A;

	}

	static boolean IsPrime(BigInteger A) {
		boolean prime = true;
		prime = SPRP(2, A);
		if (prime == true) {
			prime = SPRP(3, A);
		}
		if (prime == true) {
			prime = SPRP(5, A);
		}
		if (prime == true) {
			prime = SPRP(7, A);
		}
		return prime;
	}

	static boolean SPRP(int b1, BigInteger m1) {
		int base2 = b1;
		BigInteger modulo2 = m1;
		BigInteger power2 = modulo2.subtract(BigInteger.ONE);
		int FLT = ModExp(base2, power2, modulo2);
		if (FLT == 1) {
			while ((power2.remainder(BigInteger.valueOf(2))).compareTo(BigInteger.ZERO) == 0) {
				power2 = power2.divide(BigInteger.valueOf(2));
				FLT = ModExp(base2, power2, modulo2);
				if (FLT == 0) {
					return false;
				}
				if (FLT == -1) {
					return true;
				}
				if (FLT == 1) {
					continue;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	static int ModExp(int u, BigInteger v, BigInteger w) {
		BigInteger base = BigInteger.valueOf(u);
		BigInteger modulo = w;
		BigInteger power = v;
		String binary = new String();
		BigInteger copy = power;
		while (copy.compareTo(BigInteger.ZERO) > 0) {
			if ((copy.remainder(BigInteger.valueOf(2))).compareTo(BigInteger.ZERO) == 0) {
				binary = binary + "0";
			}
			if ((copy.remainder(BigInteger.valueOf(2))).compareTo(BigInteger.ZERO) == 1) {
				binary = binary + "1";
			}
			copy = copy.divide(BigInteger.valueOf(2));
		}
		BigInteger multiplier = base;
		int position = 0;
		BigInteger result = BigInteger.ONE;
		while (position < binary.length()) {
			if (binary.charAt(position) == '1') {
				result = result.multiply(multiplier);
				result = result.remainder(modulo);
			}
			multiplier = multiplier.multiply(multiplier);
			multiplier = multiplier.remainder(modulo);
			position = position + 1;
		}
		if (result.compareTo(BigInteger.ONE) == 0) {
			return 1;
		}
		if (result.compareTo(modulo.subtract(BigInteger.ONE)) == 0) {
			return -1;
		} else {
			return 0;
		}
	}

	static java.math.BigInteger Rho(BigInteger N2) {
		BigInteger U2 = BigInteger.valueOf(3);
		BigInteger V2 = BigInteger.valueOf(3);
		BigInteger W2;
		BigInteger M2 = BigInteger.ONE;
		BigInteger lastU = BigInteger.valueOf(3);
		BigInteger lastV = BigInteger.valueOf(3);
		int counter = 0;
		int count = 0;
		while (true) {
			while (counter < 100) {
				counter++;
				U2 = ((U2.multiply(U2)).add(BigInteger.ONE)).remainder(N2);
				V2 = ((V2.multiply(V2)).add(BigInteger.ONE)).remainder(N2);
				V2 = ((V2.multiply(V2)).add(BigInteger.ONE)).remainder(N2);
				W2 = V2.subtract(U2);
				M2 = (M2.multiply(W2)).remainder(N2);
				continue;
			}
			if (M2.compareTo(BigInteger.ZERO) < 0) {
				M2 = (BigInteger.ZERO).subtract(M2);
			}
			BigInteger G2 = GCD(M2, N2);
			count += 100;
			if (G2.compareTo(BigInteger.ONE) == 0) {
				counter = 0;
				if (count > RhoIter) {
					G2 = BigInteger.ONE;
					return G2;
				}
				lastU = U2;
				lastV = V2;
				M2 = BigInteger.ONE;
				continue;
			}
			if ((G2.compareTo(N2) == 0 || (G2.compareTo(BigInteger.ZERO) == 0))) {
				U2 = lastU;
				V2 = lastV;
				M2 = BigInteger.ONE;
				while (true) {
					U2 = ((U2.multiply(U2)).add(BigInteger.ONE)).remainder(N2);
					V2 = ((V2.multiply(V2)).add(BigInteger.ONE)).remainder(N2);
					V2 = ((V2.multiply(V2)).add(BigInteger.ONE)).remainder(N2);
					W2 = V2.subtract(U2);
					if (W2.compareTo(BigInteger.ZERO) < 0) {
						W2 = (BigInteger.ZERO).subtract(W2);
					}
					G2 = GCD(W2, N2);
					if (G2.compareTo(BigInteger.ONE) == 0) {
						continue;
					}
					if ((G2.compareTo(N2) == 0 || (G2.compareTo(BigInteger.ZERO) == 0))) {
						return N2;
					}
					if ((G2.compareTo(BigInteger.ONE) > 0) && (G2.compareTo(N2) < 0)) {
						return G2;
					}
				}
			}
			if ((G2.compareTo(BigInteger.ONE) > 0) && (G2.compareTo(N2) < 0)) {
				return G2;
			}
		}
	}

	static java.math.BigInteger GCD(BigInteger A2, BigInteger B2) {
		while (B2.compareTo(BigInteger.ZERO) > 0) {
			BigInteger C2 = B2;
			B2 = A2.remainder(B2);
			A2 = C2;
		}
		return A2;
	}

}
