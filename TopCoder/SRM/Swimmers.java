import java.util.*;
public class Swimmers {
	public int[] getSwimTimes(int[] distances, int[] speeds, int current) {
        int l = distances.length;
        int[] res = new int[l];

        for(int i = 0; i < l; i++) {
            if(distances[i] > 0 && speeds[i] <= current) {
                res[i] =  -1;
            } else {
                res[i] = (int)Math.floor(
                        ((double)distances[i] / (double)(speeds[i] + current))
                        + ((double)distances[i] / (double)(speeds[i] - current)));
            }
        }
		
        return res;
	}

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			SwimmersHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				SwimmersHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class SwimmersHarness {
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
	
	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, int[] expected, int[] received) { 
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
			int[] distances           = { 300, 300, 300 };
			int[] speeds              = { 1, 2, 3 };
			int current               = 2;
			int[] expected__          = { -1, -1, 360 };

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}
		case 1: {
			int[] distances           = { 500, 500 };
			int[] speeds              = { 4, 5 };
			int current               = 2;
			int[] expected__          = { 333, 238 };

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}
		case 2: {
			int[] distances           = { 0, 0 };
			int[] speeds              = { 1, 2 };
			int current               = 1;
			int[] expected__          = { 0, 0 };

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}
		case 3: {
			int[] distances           = { 0, 1 };
			int[] speeds              = { 0, 0 };
			int current               = 0;
			int[] expected__          = { 0, -1 };

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}
		case 4: {
			int[] distances           = { 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583, 7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691, 7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823, 7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919 };
			int[] speeds              = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 99, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 51 };
			int current               = 6;
			int[] expected__          = { -1, -1, -1, 8108, 1950, 1474, 1014, 882, 705, 544, 507, 420, 377, 359, 328, 290, 260, 252, 229, 216, 210, 195, 185, 173, 159, 155, -1, -1, 4409, 2413, 1717, 1354, 1127, 969, 852, 764, 692, 635, 585, 543, 507, 476, 449, 424, 402, 383, 365, 349, 334, 314 };

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}

		// custom cases

/*      case 5: {
			int[] distances           = ;
			int[] speeds              = ;
			int current               = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}*/
/*      case 6: {
			int[] distances           = ;
			int[] speeds              = ;
			int current               = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}*/
/*      case 7: {
			int[] distances           = ;
			int[] speeds              = ;
			int current               = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new Swimmers().getSwimTimes(distances, speeds, current));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
