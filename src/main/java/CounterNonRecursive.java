
public class CounterNonRecursive {
	static long count = 0;
	static int[] alphabet;

	private static void genericCounterNonRecursive(
			int maxLevel, 
			int[] sequence) {

		/*first word, do something with it.*/
		int alphaLen = alphabet.length - 1;
		int ptr = 0;
		while (ptr >= 0) {
			ptr = maxLevel;
			if (sequence[maxLevel] < alphaLen) {
				sequence[maxLevel]++;
				/*word completed, do something with it.*/
			} else {
				while (ptr >= 0 && sequence[ptr] == alphaLen) {
					sequence[ptr] = 0;
					ptr--;
				}
				if (ptr >= 0 && sequence[ptr] < alphaLen) {
					sequence[ptr]++;
					/*word completed, do something with it.*/
				}
			}			
		}
	}

	private static void startGenericCounter(int len) {
		int[] input = new int[len];
		for (int i=0; i<len; i++) 
			input[i] = 0;
		genericCounterNonRecursive(len-1, input);
	}

	public static void test(int vectorLength, int alphabetLength) {
		alphabet = new int[alphabetLength];
		for (int i=0; i<alphabetLength; i++) {
			alphabet[i] = i;
		}
		for (int i=1; i<=vectorLength; i++) {
			long start = System.nanoTime();
			startGenericCounter(i);
			count = (long)Math.pow(alphabet.length, i);
			long totalTime = (System.nanoTime() - start);
			System.out.println("len:\t" + i + 
					"\tcount:\t" + count + 
					"\ttime:\t" + totalTime + 
					"\telements per ms:\t" + 1000000*((double)count / (double)totalTime) );
		}
	}
}