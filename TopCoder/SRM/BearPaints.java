
import java.util.*;
public class BearPaints {
	public long maxArea(int W, int H, long M) {
        long lW = (long)W;
        long lH = (long)H;
        if(M >= lH * lW) {
            return lH * lW;
        } else {
            long max = 0;
            for(int h = 1; h < H; h++) {
                long w = Math.min(lW, M / h);
                long tmp = w * h;
                if(tmp > max) {
                    max = tmp;
                }
            }
            return max;
        }
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BearPaintsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BearPaintsHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class BearPaintsHarness {
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
			int W                     = 3;
			int H                     = 5;
			long M                    = 14;
			long expected__           = 12;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}
		case 1: {
			int W                     = 4;
			int H                     = 4;
			long M                    = 10;
			long expected__           = 9;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}
		case 2: {
			int W                     = 1000000;
			int H                     = 12345;
			long M                    = 1000000000000L;
			long expected__           = 12345000000L;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}
		case 3: {
			int W                     = 1000000;
			int H                     = 1000000;
			long M                    = 720000000007L;
			long expected__           = 720000000000L;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}
		case 4: {
			int W                     = 1000000;
			int H                     = 1000000;
			long M                    = 999999999999L;
			long expected__           = 999999000000L;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}

		// custom cases

/*      case 5: {
			int W                     = ;
			int H                     = ;
			long M                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}*/
/*      case 6: {
			int W                     = ;
			int H                     = ;
			long M                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}*/
/*      case 7: {
			int W                     = ;
			int H                     = ;
			long M                    = ;
			long expected__           = ;

			return verifyCase(casenum__, expected__, new BearPaints().maxArea(W, H, M));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
