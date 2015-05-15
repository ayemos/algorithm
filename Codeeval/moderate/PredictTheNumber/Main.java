import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            long n = Long.parseLong(line.trim());
            
            int c = 0;
            while(n > 1) {
                int mult = binlog(n);
                long min = 1L;
                min <<= mult;
                n -= min;
                c++;
            }
            System.out.println((n == 1 ? c + 1 : c) % 3);
        }
    }

    public static int binlog(long bits) {
        int log = 0;
        if( ( bits & 0xffffffff00000000L ) != 0 ) { bits >>>= 32; log = 32; }
        if( bits >= 65536 ) { bits >>>= 16; log += 16; }
        if( bits >= 256 ) { bits >>>= 8; log += 8; }
        if( bits >= 16  ) { bits >>>= 4; log += 4; }
        if( bits >= 4   ) { bits >>>= 2; log += 2; }
        return log + (int)( bits >>> 1 );
    }
}
