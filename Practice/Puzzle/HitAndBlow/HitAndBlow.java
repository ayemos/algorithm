public class HitAndBlow {
    public static void count(String target, String answer) {
        if(target == null || answer == null ||
                target.length() != answer.length()) {
            return ;
        } else {
            int hit = 0;
            int blow = 0;
            int[] tcount = new int[26];
            int[] acount = new int[26];

            for(int i = 0; i < target.length(); i++) {
                char t = target.charAt(i);
                char a = answer.charAt(i);
                if(t == a)
                    hit++;
                tcount[t - 'A']++;
                acount[a - 'A']++;
            }

            for(int i = 0; i < 26; i++)
                blow += Math.min(tcount[i], acount[i]);

            System.out.println("Hit: " + hit + ", Blow: " + (blow - hit));
        }
    }

    public static void main(String[] args) {
        count("RGGB", "YRGB");
        count("ABCD", "EFGH");
        count("ABCD", "ACED");
        count("ABCZ", "AZBC");
        count("ZABC", "ABCD");
    }
}
