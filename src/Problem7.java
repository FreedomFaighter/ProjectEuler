import java.util.ArrayList;

/* Project Euler Problem 7: 10001st Prime
 * Finds the 10001st prime number.
 */

public class Problem7 {
	public static void main(String[] args) {
		int index = 10001;
		int nthPrime;
		
		nthPrime = findPrime(index);
		System.out.println(nthPrime);
		
	}
	
	public static int findPrime(int index) {
		int origNum = 5;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		primes.add(3);
			
		while(primes.size() <= index) { //while arraylist is less than index
			int num = origNum;
			int iterator = 1;
			
			while(iterator<primes.size()) { //while iterator is less than arraylist size
				while(num%primes.get(iterator) == 0) { //goes through arraylist of primes to find factor, then divides until not divisible anymore
					num = num/primes.get(iterator);
				}
				if(num%primes.get(iterator) != 0) { //if not divisible by iterator, move on
					iterator++;
				} 

			} //You have now stripped the number of all its factors
			
			if(num != 1) { //if number does not equal to 1, its a prime
				primes.add(origNum);
			}
			origNum+=2; //skips the even numbers
		}
		
		return (int)primes.get(index-1);
	}
}
