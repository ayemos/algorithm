
import java.util.*;
public class TaroJiroDividing {
	public int getNumber(int A, int B) {
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TaroJiroDividingHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TaroJiroDividingHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class TaroJiroDividingHarness {
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
			int A                     = 8;
			int B                     = 4;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}
		case 1: {
			int A                     = 4;
			int B                     = 7;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}
		case 2: {
			int A                     = 12;
			int B                     = 12;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}
		case 3: {
			int A                     = 24;
			int B                     = 96;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}
		case 4: {
			int A                     = 1000000000;
			int B                     = 999999999;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}

		// custom cases

/*      case 5: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}*/
/*      case 6: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}*/
/*      case 7: {
			int A                     = ;
			int B                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new TaroJiroDividing().getNumber(A, B));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
