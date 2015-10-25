
import java.util.*;
public class BearDestroysDiv2 {
	public int sumUp(int W, int H, int MOD) {
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			BearDestroysDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				BearDestroysDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class BearDestroysDiv2Harness {
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
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
			int W                     = 4;
			int H                     = 3;
			int MOD                   = 999999937;
			int expected__            = 24064;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}
		case 1: {
			int W                     = 3;
			int H                     = 4;
			int MOD                   = 999999937;
			int expected__            = 24576;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}
		case 2: {
			int W                     = 2;
			int H                     = 20;
			int MOD                   = 584794877;
			int expected__            = 190795689;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}
		case 3: {
			int W                     = 5;
			int H                     = 10;
			int MOD                   = 3;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}
		case 4: {
			int W                     = 1;
			int H                     = 1;
			int MOD                   = 19;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}
		case 5: {
			int W                     = 7;
			int H                     = 40;
			int MOD                   = 312880987;
			int expected__            = 256117818;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}

		// custom cases

/*      case 6: {
			int W                     = ;
			int H                     = ;
			int MOD                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}*/
/*      case 7: {
			int W                     = ;
			int H                     = ;
			int MOD                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}*/
/*      case 8: {
			int W                     = ;
			int H                     = ;
			int MOD                   = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new BearDestroysDiv2().sumUp(W, H, MOD));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
