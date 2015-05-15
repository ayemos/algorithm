import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();

            String[] nums = line.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);

//            StringBuffer fin = new StringBuffer();
            String fin = "";
            for(int i = 1; i <= c; i++) {
                String res = "";
                if (i % a == 0) 
                    res += "F"; 

                if(i % b == 0)
                    res += "B";

                if(res.equals(""))
                    res = "" + i;

                fin += res;
                if(i < c)
                    fin += " ";
            }

            System.out.println(fin);
        }
    }
}
