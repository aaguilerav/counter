
public class Start {
	
	public static void main(String[] args) {
		int maxWordLength = 15;
		int alphabetLength = 4;
		CounterRecursive.test(maxWordLength, alphabetLength);
		System.out.println();
		CounterNonRecursive.test(maxWordLength, alphabetLength);
	}
}
