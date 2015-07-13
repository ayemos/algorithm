import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MozaicSolver2 {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    char[][] board;
    char[][] answer;

    class Point {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }

        public int hashCode() { return x + y * 31; }

        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point p = (Point)obj;
                return x == p.x && y == p.y;
            } else {
                return false;
            }
        }
    }

    Map<Set<Point>, Integer> datas = new HashMap<Set<Point>, Integer>();

    void run() throws Exception {
        int w = ni();
        int h = ni();
        board = new char[h][w];
        answer = new char[h][w];
        char[] line;
        for(int j = 0; j < h; j++) {
            line = ns().toCharArray();
            for(int i = 0; i < w; i++) {
                board[j][i] = line[i];
                answer[j][i] = '*';
            }
        }

        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) 
                System.out.print(board[j][i]);
            System.out.println("");
        }

        boolean mod = true;
        while(mod) {
            System.out.println("-----------------------------");
            for(int j = 0; j < h; j++) {
                for(int i = 0; i < w; i++) 
                    System.out.print(answer[j][i]);
                System.out.println("");
            }
            System.out.println("-----------------------------");
            mod = false;
            for(int i = 0; i < w; i++) {
                for(int j = 0; j < h; j++) {
                    if(board[j][i] == '-')
                        continue;

                    int n = board[j][i] - '0';
                    Point p = new Point(i, j);

                    for(Map.Entry<Set<Point>, Integer> e : datas.entrySet()) {
                        Set<Point> points = e.getKey();
                        int needs = e.getValue();
                        if(needs == n) {
                        }
                    }

                    Set<Point> points       = getPointsAround(i, j);
                    Set<Point> whitePoints  = getWhitePoints(points);
                    Set<Point> blackPoints  = getBlackPoints(points);
                    Set<Point> arbitPoints  = getArbitPoints(points);

                    if(blackPoints.size() == n && !arbitPoints.isEmpty()) {
                        check(i, j, false);
                        mod = true;
                    }

                    if(blackPoints.size() + arbitPoints.size() == n &&
                            !arbitPoints.isEmpty()) {
                        check(i, j, true);
                        mod = true;
                    }

                    whitePoints = getWhitePoints(points);
                    blackPoints = getBlackPoints(points);
                    arbitPoints = getArbitPoints(points);

                    Set<Point> tmp;
                    for(Map.Entry<Set<Point>, Integer> data : datas.entrySet()) {
                        if(points.containsAll(data.getKey())) {
                            tmp = new HashSet<Point>(whitePoints);
                            tmp.removeAll(data.getKey());
                            // tmp.size() == ...
                        }
                    }

                    datas.put(arbitPoints, n - blackPoints.size());
                }
            }
        }

        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) 
                System.out.print(answer[j][i]);
            System.out.println();
        }
    }

    void check(Point p, boolean black) {
        check(p.x, p.y, black);
    }
    void check(int x, int y, boolean black) {
        for(int i = y - 1; i <= y + 1; i++) 
            for(int j = x - 1; j <= x + 1; j++) 
                if(i >= 0 && i < board.length &&
                        j >= 0 && j < board[0].length)
                    if(answer[i][j] == '*')
                        answer[i][j] = black ? '#' : '.';
    }

    Set<Point> getPointsAround(int x, int y) {
        Set<Point> res = new HashSet<Point>();
        for(int i = y - 1; i <= y + 1; i++) 
            for(int j = x - 1; j <= x + 1; j++) 
                if(i >= 0 && i < board.length &&
                        j >= 0 && j < board[0].length)
                    res.add(new Point(j, i));
        return res;
    }

    Set<Point> getWhitePoints(Set<Point> points) {
        Set<Point> res = new HashSet<Point>();
        for(Point point : points) 
            if(answer[point.y][point.x] == '.')
                res.add(point);
        return res;
    }

    Set<Point> getBlackPoints(Set<Point> points) {
        Set<Point> res = new HashSet<Point>();
        for(Point point : points) 
            if(answer[point.y][point.x] == '#')
                res.add(point);
        return res;
    }

    Set<Point> getArbitPoints(Set<Point> points) {
        Set<Point> res = new HashSet<Point>();
        for(Point point : points) 
            if(answer[point.y][point.x] == '*')
                res.add(point);
        return res;
    }

    /*
     * Templates
     */
    void dumpObjArr(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
        System.out.println("");
    }

    void dumpObjArr2(Object[][] arr, int m, int n) {
        for(int j = 0; j < m; j++) 
            dumpObjArr(arr[j], n);
    }

    int ni() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    long nl() throws Exception {
        return Long.parseLong(br.readLine().trim());
    }

    String ns() throws Exception {
        return br.readLine();
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    int getPrime(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int count = 1;

        int x = 1;
        while(primes.size() < n) {
            x+=2;
            int m = (int)Math.sqrt(x);
            for(int p : primes) {
                if(p > m) {
                    primes.add(x);
                    break;
                }

                if(x % p == 0) 
                    break;
            }
        }

        return primes.get(primes.size() - 1);
    }

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new MozaicSolver2().run();
    }
}




