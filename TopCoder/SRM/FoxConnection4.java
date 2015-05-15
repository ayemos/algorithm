
import java.util.*;
public class FoxConnection4 {
    public String[] b;
    public int[][] memo;
    public int k;
    public final int MOD = 1000000009;

	public int howManyWays(String[] board, int k) {
        this.k = k;
	    this.b = board;

        int w = board[0].length();
        int h = board.length;

        int sum = 0;

        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(charAt(i, j) == '.') {
                    this.memo = new int[w][h];
                    sum += solve(i, j, 0);
                    sum %= MOD;
                }
            }
        }

        return sum;
	}

    public int solve(int x, int y, int count) {
        if(count == 0) 
            return 1;
        int dxs[] = {0, 1, -1, 0};
        int dys[] = {1, 0, 0, -1};

        int dx, dy;
        int sum = count;
        for(int i = 0; i < 4; i++) {
            dx = dxs[i];
            dy = dys[i];
            if(charAt(x + dx, y + dy) == '.') {
                sum += solve(x + dx, y + dy, count - 1);
            } else {
            }
        }

        return sum;
    }

    public char charAt(int x, int y) {
        return b[y].charAt(x);
    }

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			FoxConnection4Harness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				FoxConnection4Harness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class FoxConnection4Harness {
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
			String[] board            = {"....."}
;
			int k                     = 3;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}
		case 1: {
			String[] board            = {".#.#",
 "#.#.",
 ".#.#",
 "#.#."}
;
			int k                     = 2;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}
		case 2: {
			String[] board            = {"##.",
 "...",
 ".##"}
;
			int k                     = 3;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}
		case 3: {
			String[] board            = {"....",
 "....",
 "....",
 "...."};
			int k                     = 4;
			int expected__            = 113;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}
		case 4: {
			String[] board            = {".....#....",
 ".#........",
 "....#.##..",
 "#......#..",
 "....#.....",
 "..........",
 ".##....#..",
 "..##......",
 "........##",
 "......#.#."}
;
			int k                     = 8;
			int expected__            = 22369;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}

		// custom cases

/*      case 5: {
			String[] board            = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}*/
/*      case 6: {
			String[] board            = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}*/
/*      case 7: {
			String[] board            = ;
			int k                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new FoxConnection4().howManyWays(board, k));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
