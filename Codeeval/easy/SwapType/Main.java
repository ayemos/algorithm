import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            char[] cs = line.toCharArray();
            char[] res = new char[cs.length];
            for(int i = 0; i < cs.length; i++) {
                char c = cs[i];
                if(c >= 'a' && c <= 'z') {
                    res[i] = (char)(c + 'A' - 'a');
                } else if(c >= 'A' && c <= 'Z'){
                    res[i] = (char)(c + 'a' - 'A');
                } else {
                    res[i] = c;
                }
            }
            System.out.println(String.valueOf(res));
        }
    }
}

