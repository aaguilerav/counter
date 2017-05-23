package main.generic.counter;

public class Start {
	
	public static void main(String[] args) {
		int maxWordLength = 16;
		int alphabetLength = 4;
		CounterRecursive.test(maxWordLength, alphabetLength);
		System.out.println();
		CounterNonRecursive.test(maxWordLength, alphabetLength);
	}
}
