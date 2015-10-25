
import java.util.*;
public class BearDartsDiv2 {
    class Pair {
        int c;
        long m;
        public Pair(int c, long m) {
            this.c = c; this.m = m;
        }

        public String toString() {
            return this.c + ":" + this.m;
        }

        public boolean equals(Object obj) {
            if(obj instanceof Pair) {
                Pair p = (Pair)obj;
                return p.c == this.c && p.m == this.m;
            }

            return false;
        }
    }
	public long count(int[] ws) {
        long c = 0;
        int w = ws.length;
            Map<Integer, Pair> countMap = new HashMap<Integer, Pair>();

        for(int i = 0; i < w - 3; i++) {
            for(int j = i + 1; j < w - 2; j++) {
                for(int k = j + 1; k < w - 1; k++) {
                    for(int l = k + 1; l < w; l++) {
                        if(ws[i] * ws[j] * ws[k] == ws[l])
                            c++;
                    }
                }
            }
        }

        return c;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BearDartsDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BearDartsDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class BearDartsDiv2Harness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(long expected, long result) { return expected == result; }
	static String formatResult(long res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, long expected, long received) { 
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected)); 
			System.err.println("    Received: " + formatResult(received)); 
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch(casenum__) {
		case 0: {
			int[] w                   = {10,2,2,7,40,160};
			long expected__           = 2;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}
		case 1: {
			int[] w                   = {128,64,32,16,8,4,2,1};
			long expected__           = 0;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}
		case 2: {
			int[] w                   = {2,3,4,5,6,8,12,16,20,24,40,24,20,16,12,8,6,5,4,3,2};
			long expected__           = 3;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}
		case 3: {
			int[] w                   = {100,100,100,1000000,1000000,1000000,1000000,1000000};
			long expected__           = 5;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}
		case 4: {
			int[] w                   = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
			long expected__           = 2573031125L;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}

		// custom cases

/*      case 5: {
			int[] w                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}*/
/*      case 6: {
			int[] w                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}*/
/*      case 7: {
			int[] w                   = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearDartsDiv2().count(w));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
