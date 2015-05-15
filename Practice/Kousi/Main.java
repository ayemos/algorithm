import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int MAX_N = 51;

    List<Integer> points = new ArrayList<Integer>();

    void run() throws Exception {
        int n = ni();
        for(int i = 0; i < n; i++) {
            String[] nums = ns().split(" ");
            points.add(Integer.parseInt(nums[0]) * MAX_N + Integer.parseInt(nums[1]));
        }

        int p, q, px, py, qx, qy;
        int c = 0;
        int x1, x2, y1, y2;

        for(int i = 0; i < points.size() - 1; i++) {
            p = points.get(i);
            for(int j = i + 1; j < points.size(); j++) {
                q = points.get(j);
                px = p / MAX_N; py = p % MAX_N;
                qx = q / MAX_N; qy = q % MAX_N;

                int dx = Math.abs(px - qx);
                int dy = Math.abs(py - qy);
                x1 = px - dy;
                y1 = py + dx;
                x2 = qx - dy;
                y2 = qy + dx;
                if(points.contains(x1 * MAX_N + y1) && 
                        points.contains(x2 * MAX_N + y2))
                    c++;

                x1 = px + dy;
                y1 = py - dx;
                x2 = qx + dy;
                y2 = qy - dx;
                if(points.contains(x1 * MAX_N + y1) && 
                        points.contains(x2 * MAX_N + y2)) 
                    c++;
            }
        }

        System.out.println(c / 4);
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
        new Main().run();
    }
}




