
import java.util.*;
public class DecipherabilityEasy {
	public String check(String s, String t) {

        int p = 0;
        boolean removed = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(p < t.length() && c == t.charAt(p)) {
                p++;
                continue;
            } else if(removed){
                return "Impossible";
            } else {
                removed = true;
                continue;
            }
        }

        return removed ? "Possible" : "Impossible";
		
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			DecipherabilityEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				DecipherabilityEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class DecipherabilityEasyHarness {
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
			String s                  = "sunuke";
			String t                  = "snuke";
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 1: {
			String s                  = "snuke";
			String t                  = "skue";
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 2: {
			String s                  = "snuke";
			String t                  = "snuke";
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 3: {
			String s                  = "snukent";
			String t                  = "snuke";
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 4: {
			String s                  = "aaaaa";
			String t                  = "aaaa";
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 5: {
			String s                  = "aaaaa";
			String t                  = "aaa";
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 6: {
			String s                  = "topcoder";
			String t                  = "tpcoder";
			String expected__         = "Possible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}
		case 7: {
			String s                  = "singleroundmatch";
			String t                  = "singeroundmatc";
			String expected__         = "Impossible";

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}

		// custom cases

/*      case 8: {
			String s                  = ;
			String t                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}*/
/*      case 9: {
			String s                  = ;
			String t                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}*/
/*      case 10: {
			String s                  = ;
			String t                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new DecipherabilityEasy().check(s, t));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
