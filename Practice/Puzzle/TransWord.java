import java.util.*;

public class TransWord {
    private static Set<String> dict = new HashSet<String>();

    public static void initDict() {
        dict.add("DAMP");
        dict.add("LAMP");
        dict.add("LIMP");
        dict.add("LIME");
        dict.add("LIKE");
    }

    public static List<String> trans(char[] a, char[] b) {
        System.out.println("a:b => " + String.valueOf(a) + ":" + String.valueOf(b));
        if(same(a, b)) {
            List<String> res = new ArrayList<String>();
            res.add(String.valueOf(a));
            return res;
        } else {
            char[] word = new char[a.length];
            System.arraycopy(a, 0, word, 0, a.length);
            List<String> res = new ArrayList<String>();

            for(int i = 0; i < a.length; i++) {
                if(word[i] != b[i]) {
                    word[i] = b[i];
                    System.out.println(String.valueOf(word));
                    if(dict.contains(String.valueOf(word))) {
                        res = trans(word, b);
                        if(!res.isEmpty()) {
                            res.add(0, String.valueOf(a));
                            return res;
                        }
                    }
                    word[i] = a[i];
                }
            }

            return res;
        }
    }

    public static boolean same(char[] a, char[] b) {
        for(int i = 0; i < a.length; i++) 
            if(a[i] != b[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String fstr = "DAMP";
        char[] from = fstr.toCharArray();
        String tstr = "LIKE";
        char[] to = tstr.toCharArray();
        initDict();
        System.out.println(trans(from, to));
    }
}
