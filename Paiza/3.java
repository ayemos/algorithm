import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            long num = Long.parseLong(line.substring(0, line.length() - 1), 10);

            int checksum = 0;
            for (int i = 0; i < 15; i++) {
                int digit = (int)(num % 10);

                if (i % 2 == 0) {
                    int res = digit * 2;
                    if (res >= 10)
                        res = (res / 10) + (res % 10);
                    checksum += res;
                } else {
                    checksum += digit;
                }


                num /= 10;
            }

            System.out.println((10 - (checksum % 10)) % 10);
        }
    }
}
