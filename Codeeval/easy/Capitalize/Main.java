
import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] ws = line.split(" ");
            String res = "";
            for(int i = 0; i < ws.length; i++) {
                char c = ws[i].charAt(0);
                String ret = ws[i];
                if(c >= 'a' && c <= 'z') {
                    String conv = String.valueOf((char)(c + 'A' - 'a'));
                    ret =  conv + ws[i].substring(1, ws[i].length());
                }
                res += ret + " ";
            }
            System.out.println(res.substring(0, res.length() - 1));
        }
    }
}

