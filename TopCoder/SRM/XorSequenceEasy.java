
import java.util.*;
public class XorSequenceEasy {
    int n;

	public int getmax(int[] A, int N) {
        int res = 0;
        this.n = N;

        return res;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			XorSequenceEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				XorSequenceEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class XorSequenceEasyHarness {
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
			int[] A                   = {3,2,1,0,3,2};
			int N                     = 4;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}
		case 1: {
			int[] A                   = {3,0,4,6,1,5,7,6};
			int N                     = 8;
			int expected__            = 21;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}
		case 2: {
			int[] A                   = {3,1,4,1,5,9,2,6,5,3,5,8,9,7,9};
			int N                     = 16;
			int expected__            = 76;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}
		case 3: {
			int[] A                   = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
			int N                     = 8;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}
		case 4: {
			int[] A                   = {408024109,11635919,196474438,117649705,812669700,553475508,445349752,271145432,730417256,738416295 ,147699711,880268351,816031019,686078705,1032012284,182546393,875376506,220137366,906190345,16216108 ,799485093,715669847,413196148,122291044,777206980,68706223,769896725,212567592,809746340,964776169 ,928126551,228208603,918774366,352800800,849040635,941604920,326686120,920977486,964528038,659998484 ,207195539,607901477,725914710,655525412,949610052,142750431,766838105,1024818573,836758851,97228667};
			int N                     = 1073741824;
			int expected__            = 720;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}

		// custom cases

/*      case 5: {
			int[] A                   = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}*/
/*      case 6: {
			int[] A                   = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}*/
/*      case 7: {
			int[] A                   = ;
			int N                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new XorSequenceEasy().getmax(A, N));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
