import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] ws = line.split(" ");
            int n = Integer.parseInt(ws[ws.length-1]);
            if(n > ws.length - 1 || n < 1) continue;
            System.out.println(ws[ws.length - n - 1]);
        }
    }
}
