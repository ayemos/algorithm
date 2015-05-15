
import java.util.*;
public class Twain {
	public String getNewSpelling(int year, String phrase) {
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TwainHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				TwainHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class TwainHarness {
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
			int year                  = 1;
			String phrase             = "i fixed the chrome xerox by the cyclical church";
			String expected__         = "i fiksed the chrome zeroks by the cyclical church";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 1: {
			int year                  = 2;
			String phrase             = "i fixed the chrome xerox by the cyclical church";
			String expected__         = "i fiksed the chrome zeroks bi the ciclical church";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 2: {
			int year                  = 0;
			String phrase             = "this is unchanged";
			String expected__         = "this is unchanged";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 3: {
			int year                  = 7;
			String phrase             = "sch kn x xschrx cknnchc cyck xxceci";
			String expected__         = "sk n z zskrks nchk sik zksesi";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 4: {
			int year                  = 7;
			String phrase             = "  concoction   convalescence   cyclical   cello   ";
			String expected__         = "  konkoktion   konvalesense   siklikal   selo   ";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 5: {
			int year                  = 7;
			String phrase             = "";
			String expected__         = "";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}
		case 6: {
			int year                  = 7;
			String phrase             = "cck xzz aaaaa";
			String expected__         = "k z aaaaa";

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}

		// custom cases

/*      case 7: {
			int year                  = ;
			String phrase             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}*/
/*      case 8: {
			int year                  = ;
			String phrase             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}*/
/*      case 9: {
			int year                  = ;
			String phrase             = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new Twain().getNewSpelling(year, phrase));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
