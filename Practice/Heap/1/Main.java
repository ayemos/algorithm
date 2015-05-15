import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] heap;
    int sz;
    int N = 50;

    void run() throws Exception {
        heap = new int[N];
        sz = 0;

        dumpHeap();
        push(10);
        dumpHeap();
        push(3);
        push(5);
        push(8);
        push(1);
        push(2);
        push(11);
        push(7);
        dumpHeap();
        System.out.println("POP: " + pop());
        dumpHeap();
        System.out.println("POP: " + pop());
        dumpHeap();
        System.out.println("POP: " + pop());
        dumpHeap();
        System.out.println("POP: " + pop());
        dumpHeap();
        System.out.println("POP: " + pop());
        dumpHeap();
    }

    void dumpHeap() {
        int pow = 0;
        int c = 1;
        for(int i = 0 ; i < N; i++) {
            System.out.print(heap[i] + " ");

            if((c + 1) % Math.pow(2, pow) == 0) {
                System.out.println("");
                pow++;
            }
            c++;

        }
        System.out.println("");
    }

    int pop() {
        int res = heap[0];
        int x = heap[--sz];

        int i = 0;

        while(i * 2 + 1 < sz) {
            int a = i * 2 + 1;
            int b = i * 2 + 2;
            if(b < sz && heap[a] > heap[b]) a = b;

            if(heap[a] >= x) break;

            heap[i] = heap[a];
            i = a;
        }

        heap[i] = x;

        return res;
    }

    void push(int x) {
        int i = sz++;

        while(i > 0) {
            int p = (i - 1) / 2; // parent
            
            if(heap[p] <= x) break;

            heap[i] = heap[p];
            i = p;
        }

        heap[i] = x;
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

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




