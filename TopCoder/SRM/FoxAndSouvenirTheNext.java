
import java.util.*;
public class FoxAndSouvenirTheNext {
	public String ableToSplit(int[] value) {
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxAndSouvenirTheNextHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FoxAndSouvenirTheNextHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class FoxAndSouvenirTheNextHarness {
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
	
	static boolean compareOutput(String expected, String result) { return expected.equals(result); }
	static String formatResult(String res) {
		return String.format("\"%s\"", res);
	}
	
	static int verifyCase(int casenum, String expected, String received) { 
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
			int[] value               = {1,2,3,4};
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}
		case 1: {
			int[] value               = {1,1,1,3};
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}
		case 2: {
			int[] value               = {1,1,2,3,5,8};
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}
		case 3: {
			int[] value               = {2,3,5,7,11,13};
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}
		case 4: {
			int[] value               = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48};
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}
		case 5: {
			int[] value               = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}

		// custom cases

/*      case 6: {
			int[] value               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}*/
/*      case 7: {
			int[] value               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}*/
/*      case 8: {
			int[] value               = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new FoxAndSouvenirTheNext().ableToSplit(value));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
