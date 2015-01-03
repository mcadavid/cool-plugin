package net.eulerproject.problemNo3;

import java.math.BigInteger;

import net.eulerproject.utils.PrimeNumbersUtils;

public class LargestPrimeFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger number = new BigInteger("600851475143");
		
		//BigInteger number = new BigInteger("123");
		
		
		double limit = Math.sqrt(number.doubleValue());
		
		
		BigInteger result = number;
		long maximum = 0;
		System.out.println(number);
		
		for (long i = 2;   (i< new Double(limit / 2).longValue()) ; i++) {
			
			BigInteger[] resultAndRemainder = result.divideAndRemainder(new BigInteger(i+""));
			
			if (resultAndRemainder[1].equals(BigInteger.ZERO)){
				
				result = resultAndRemainder[0];
				
				
				if (PrimeNumbersUtils.isPrime(i)){
					maximum = i;
				}
				if ((PrimeNumbersUtils.isPrime(result.longValue())) && maximum < result.longValue()){
					maximum = result.longValue();
				}
			}
			
			if (result.compareTo(new BigInteger("1")) == 0){
				break;
			}
			
		}
		
		System.out.println("bigger prime factor of "+ number +" is "+ maximum);
		

	}
	
	private static boolean isPrime(long n){
		
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0){
				return false;
			}
		}
		return true;
	}

}
