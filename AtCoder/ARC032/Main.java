import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int x = n * (n+1) / 2;
         
    }

    public static boolean isPrime(int n) {
        for(int i=2;i<n;i++) 
            if(n%i==0)
                return false;
        return true;
    }
}


