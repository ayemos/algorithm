import java.util.*;
public class CartInSupermarketEasy {
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
    };

	public int calc(int N, int K) {
        List<Integer> seqs = new ArrayList<Integer>();
        seqs.add(N);
        return solve(seqs, K, 0);
	}

    public int solve(List<Integer> seqs, int k, int min) {
        System.out.println(seqs);
        System.out.println(k);
        System.out.println(min);

        if(seqs.isEmpty()) return min;

        List<Integer> tmp = new ArrayList<Integer>();
        List<Integer> ress = new ArrayList<Integer>();

        int p1 = 0;
        int m;
        while(k > 0 && p1 < seqs.size()) {
            m = seqs.get(p1);
            if(m > 1) {
                tmp.add(m % 2 == 0 ? m / 2 : (m + 1) / 2);
                tmp.add(m % 2 == 0 ? m / 2 : (m - 1) / 2);
                k--;
            }
            p1++;
        }

        while(p1 < seqs.size()) {
            if(seqs.get(p1) > 1) {
                tmp.add(seqs.get(p1) - 1);  
            }
            p1++;
        }

        return solve(tmp, k, min + 1);
    }

// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			CartInSupermarketEasyHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				CartInSupermarketEasyHarness.run_test(Integer.valueOf(args[i]));
		}
	}
// END CUT HERE	
}
// BEGIN CUT HERE
class CartInSupermarketEasyHarness {
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
			int N                     = 5;
			int K                     = 0;
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}
		case 1: {
			int N                     = 5;
			int K                     = 2;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}
		case 2: {
			int N                     = 15;
			int K                     = 4;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}
		case 3: {
			int N                     = 7;
			int K                     = 100;
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}
		case 4: {
			int N                     = 45;
			int K                     = 5;
			int expected__            = 11;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}
		case 5: {
			int N                     = 100;
			int K                     = 100;
			int expected__            = 8;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}

		// custom cases

/*      case 6: {
			int N                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}*/
/*      case 7: {
			int N                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}*/
/*      case 8: {
			int N                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new CartInSupermarketEasy().calc(N, K));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
