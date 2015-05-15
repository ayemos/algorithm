import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int[] COINS = {500, 100, 50, 10, 5, 1};

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            int change = 1000 - Integer.parseInt(line);
            int[] res = new int[COINS.length];
            for(int i = 0; i < COINS.length; i++) {
                while(change >= COINS[i]) {
                    change -= COINS[i];
                    res[i]++;
                }
            }

            for(int i = 0; i < COINS.length; i++) 
                System.out.println(COINS[i] + " * " + res[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




