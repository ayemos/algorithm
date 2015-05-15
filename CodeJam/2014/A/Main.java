import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            String[] nums = ns().split(" ");
            int n = Integer.parseInt(nums[0]);
            int l = Integer.parseInt(nums[1]);

            List<String> outlets = new ArrayList<String>();
            for(String s : ns().split(" ")) 
                outlets.add(s);

            Set<String> devices = new HashSet<String>();
            for(String s : ns().split(" ")) 
                devices.add(s);

            int min = Integer.MAX_VALUE;

            String sample = outlets.get(0);
            boolean flag;
            for(String device : devices) {
                List<Integer> proc = calc(sample, device);
                /*
                System.out.println("device to sample: " + device + ":" + sample);
                System.out.println(proc);
                */
                flag = true;
                for(String outlet : outlets) {
                 //   System.out.println(change(outlet, proc));
                    if(!devices.contains(change(outlet, proc))) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    int tmp = proc.size();
                    if(tmp < min) 
                        min = tmp;
                }
            }

            if(min == Integer.MAX_VALUE) {
                gcjPrint("NOT POSSIBLE", t+1);
            } else {
                gcjPrint(Integer.toString(min), t+1);
            }

        }
    }

    String change(String source, List<Integer> proc) {
        int len = source.length();
        char[] tmp = new char[len];

        for(int i = 0; i < len; i++) 
            if(proc.contains(i)) 
                tmp[i] = source.charAt(i) == '1' ? '0' : '1';
            else 
                tmp[i] = source.charAt(i);

        return String.valueOf(tmp);
    }

    List<Integer> calc(String from, String to) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < from.length(); i++) 
            if(from.charAt(i) != to.charAt(i))
                res.add(i);

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
        new Main().run();
    }
}




