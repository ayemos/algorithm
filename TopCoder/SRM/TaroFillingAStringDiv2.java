
import java.util.*;
public class TaroFillingAStringDiv2 {
	public int getNumber(String S) {
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TaroFillingAStringDiv2Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TaroFillingAStringDiv2Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class TaroFillingAStringDiv2Harness {
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
			String S                  = "ABAA";
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}
		case 1: {
			String S                  = "??";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}
		case 2: {
			String S                  = "A?A";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}
		case 3: {
			String S                  = "A??B???AAB?A???A";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}
		case 4: {
			String S                  = "?BB?BAAB???BAB?B?AAAA?ABBA????A?AAB?BBA?A?";
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}

		// custom cases

/*      case 5: {
			String S                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}*/
/*      case 6: {
			String S                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}*/
/*      case 7: {
			String S                  = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroFillingAStringDiv2().getNumber(S));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
