import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        long[] count = new long[26];

        Deque<Long> coefs = new LinkedList<Long>();
        coefs.addFirst(1L);
        parse(line, 0, 1, coefs, count);
        dumpcount(count);
    }

    public static void dumpcount(long[] count) {
        char c = 'a';
        for(int i = 0; i < 26; i++)  {
            System.out.println(c + " " + count[i]);
            c++;
        }
    }

    public static void parse(char[] line, int index, long coef, 
            Deque<Long> coefStack, long[] count) {
        while(index < line.length) {

            char c = line[index];
            if (c >= 'a' && c <= 'z') {
                count[c - 'a'] += coef;
                index++;
                continue;
            } else if (c == '(') {
                continue;
            } else if (c == ')') {
                long tempCoef = coefStack.removeFirst();
                index++;
                coef /= tempCoef;
                continue;
            } else {
                // got a number
                int fin = index+1;
                while(line[fin] >= '0' && line[fin] <= '9') {
                    fin++;
                }

                // line[index] ~ line[fin] is number
                char[] digits = Arrays.copyOfRange(line, index, fin);  
                Long tempCoef = Long.parseLong(new String(digits));

                char next = line[fin];
                if(next == '(') {
                    coefStack.addFirst(tempCoef);
                    index = fin+1;
                    coef *= tempCoef;
                    continue;
                } else {
                    // 一文字の場合はここで個別に処理
                    count[next - 'a'] += coef * tempCoef;
                    index = fin+1;
                    continue;
                }
            }
        }
    }

}
