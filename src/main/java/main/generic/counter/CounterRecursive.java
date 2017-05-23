package main.generic.counter;

public class CounterRecursive {
	static long count = 0;
	static int[] alphabet;

	private static void genericCounterRecursive(int level, int maxLevel, int[] sequence) {
		if (level == 0) {
			/*word completed, do something with it.*/
			return;
		}
		for (int i=0; i<alphabet.length; i++) {
			sequence[maxLevel - level] = alphabet[i];
			genericCounterRecursive(level-1, maxLevel, sequence);
		}
	}

	private static void startGenericCounter(int len) {
		genericCounterRecursive(len, len, new int[len]);
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