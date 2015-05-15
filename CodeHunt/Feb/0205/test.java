public static String Puzzle(String s, int n) {
    int len, tmp;
    String[] ss;
    String res = "";

    s = s.replaceAll("\\.+", ".");

    ss = s.split("\\.");
    len = n - s.length() + ss.length - 1;

    System.out.println(s);
    System.out.println(len);

    String w;
    for(int i = 0; i < ss.length - 1; i++) {
        w = ss[i];
        res += w;
        tmp = len;
        for(int j = 0; j < (int)Math.ceil((double)tmp / (ss.length - i - 1)); j++) {
            res += ".";
            len--;
        }
    }
    return res + ss[ss.length - 1];
}
