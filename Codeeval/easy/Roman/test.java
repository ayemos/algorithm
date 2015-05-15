

public class Main {
    String[][] marks = 
    {
        {"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}
    };

    public String Puzzle(int num) {
        int exp = 0;
        String res = "";
        while(num > 0) {
            String nStr = "";
            int n = num % 10;
            if(n == 9) {
                nStr = marks[exp][0] + marks[exp+1][0];
            } else if(n == 4) {
                nStr = marks[exp][0] + marks[exp][1];
            } else {
                if(n >= 5) {
                    n -= 5;
                    nStr += marks[exp][1];
                }

                for(int i = 0; i < n; i++) 
                    nStr += marks[exp][0];
            }

            res = nStr + res;
            num /= 10;
            exp++;
        }
        System.out.println(res);
    }
}
