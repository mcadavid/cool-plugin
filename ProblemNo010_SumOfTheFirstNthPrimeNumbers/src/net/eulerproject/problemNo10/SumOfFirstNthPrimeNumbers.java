package net.eulerproject.problemNo10;

import java.math.BigInteger;

import net.eulerproject.utils.PrimeNumbersUtils;

public class SumOfFirstNthPrimeNumbers {

	public long calculate(int limit) {

		long sum = 2;
		int candidate = 1;
		while (candidate < limit-2){
			candidate = candidate + 2;
			if (PrimeNumbersUtils.isPrime(candidate)) {
				sum = sum + candidate;
			}
		}
		
		
		return sum;
	}

	public long calculateUsingEratosthenesSieve(int limit){
//		sievebound := (limit-1) div 2 // last index of sieve
//				sieve := new boolean array [1 .. sievebound] false
//				crosslimit := (b
//				p
//				limitc-1) div 2
//				for i := 1 to crosslimit
//				if not sieve[i] then // 2*i+1 is prime, mark multiples
//				for j:= 2*i*(i+1) to sievebound with step 2*i+1
//				sieve[j] := true
//				end for
//				end if
//				end for
//				sum := 2 // 2 is prime
//				for i := 1 to sievebound
//				if not sieve[i] then sum := sum+(2*i+1)
//				end for
//				output sum
		return 0;
	}
}
