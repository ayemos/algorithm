
import java.util.*;
public class RobotOnMoonEasy {
	public String isSafeCommand(String[] board, String S) {
        int dx = 0, dy = 0;
        int x = 0, y = 0;
        int w = board[0].length();
        int h = board.length;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(charAt(j, i, board) == 'S') {
                    x = j; 
                    y = i;
                }
            }
        }

        for(char c : S.toCharArray()) {
            switch(c) {
                case 'U':
                    dy = -1;
                    dx = 0;
                    break;
                case 'D':
                    dy = 1;
                    dx = 0;
                    break;
                case 'L':
                    dy = 0;
                    dx = -1;
                    break;
                case 'R':
                    dy = 0;
                    dx = 1;
                    break;
            }

            if(x + dx >= w || x + dx < 0 
                    || y + dy >= h || y + dy < 0) {
                return "Dead";
                    }

            if(charAt(x + dx, y + dy, board) == '.') {
                x += dx;
                y += dy;
            }
        }

        return "Alive";
	}

    public char charAt(int i, int j, String[] board) {
        return board[j].charAt(i);
    }

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			RobotOnMoonEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				RobotOnMoonEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class RobotOnMoonEasyHarness {
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
			String[] board            = {".....",
 ".###.",
 "..S#.",
 "...#."};
			String S                  = "URURURURUR";
			String expected__         = "Alive";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}
		case 1: {
			String[] board            = {".....",
 ".###.",
 "..S..",
 "...#."};
			String S                  = "URURURURUR";
			String expected__         = "Dead";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}
		case 2: {
			String[] board            = {".....",
 ".###.",
 "..S..",
 "...#."};
			String S                  = "URURU";
			String expected__         = "Alive";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}
		case 3: {
			String[] board            = {"#####",
 "#...#",
 "#.S.#",
 "#...#",
 "#####"};
			String S                  = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
			String expected__         = "Alive";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}
		case 4: {
			String[] board            = {"#####",
 "#...#",
 "#.S.#",
 "#...#",
 "#.###"};
			String S                  = "DRULURLDRULRUDLRULDLRULDRLURLUUUURRRRDDLLDD";
			String expected__         = "Dead";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}
		case 5: {
			String[] board            = {"S"};
			String S                  = "R";
			String expected__         = "Dead";

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}

		// custom cases

/*      case 6: {
			String[] board            = ;
			String S                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}*/
/*      case 7: {
			String[] board            = ;
			String S                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}*/
/*      case 8: {
			String[] board            = ;
			String S                  = ;
			String expected__         = ;

			return verifyCase(casenum__, expected__, new RobotOnMoonEasy().isSafeCommand(board, S));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
