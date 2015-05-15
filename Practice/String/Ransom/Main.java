public class Main {
    private static final int NUM_ALPHABETS = 26;

    public static boolean canBuildRansom(String note, String mag) 
    throws Exception {
        if(note == null || note.equals("")
                || mag == null || mag.equals(""))
            throw new Exception("Empty note or mag");

        if(note.length() > mag.length())
            return false;

        // note < mag
        int[] chars = new int[NUM_ALPHABETS];
        int count = 0;
        for(int i = 0; i < note.length(); i++) {
            char c = note.charAt(i);
            int p = c - 'a';
            if(p < NUM_ALPHABETS) {
                chars[p]++;
                count++;
            } else {
                throw new Exception("Illegal note");
            }
        }

        for(int i = 0; i < mag.length(); i++) {
            char c = mag.charAt(i);
            int p = c - 'a';
            if(p < NUM_ALPHABETS) {
                if(chars[p] > 0) {
                    chars[c - 'a']--;
                    count--;

                    if(count == 0)
                        return true;
                }
            } else {
                throw new Exception("Illegal mag");
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(canBuildRansom("dog", "goodnews"));
        System.out.println(canBuildRansom("dog", "pennylane"));
    }
}




