package net.eulerproject.problemNo7;

import net.eulerproject.utils.PrimeNumbersUtils;


public class FindTheNthPrimeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		int primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(2);
		assertTrue(primeNumber == 3);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(3);
		assertTrue(primeNumber == 5);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(4);
		assertTrue(primeNumber == 7);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(5);
		assertTrue(primeNumber == 11);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(6);
		assertTrue(primeNumber == 13);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(7);
		assertTrue(primeNumber == 17);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(8);
		assertTrue(primeNumber == 19);
		
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(9);
		assertTrue(primeNumber == 23);
		
		long firstMeasure = System.currentTimeMillis();
		primeNumber = new FindTheNthPrimeNumber().findThePrimeNumber(10001);
		System.out.println(System.currentTimeMillis() - firstMeasure);
		
	}

	private int findThePrimeNumber(int limit){
		
		if (limit == 1){
			return 2;
		}
		
		int counter = 1;
		int candidate = 1;
		while (counter < limit){
			
			candidate = candidate + 2;
			
			if (PrimeNumbersUtils.isPrime(candidate)){
				counter++;
			}
			
		}
		System.out.println(candidate);
		return candidate;
	}
	
	
	private static void assertTrue(boolean trueValue) throws Exception{
		if (!trueValue){
			throw new Exception();
		}
	}

}