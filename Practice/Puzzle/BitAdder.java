public class BitAdder {
    public static int add(int a, int b) {
        int res = 0;
        boolean c = false, s = false;
        for(int i = 0; i < 32; i++) {
            boolean aa = (a & 1) != 0;
            boolean bb = (b & 1) != 0;
            s = aa ^ bb ^ c;
            c = (aa & bb) | (bb & c) | (c & aa);
            if(s)
                res = updateBit(res, i);

            a = a >>> 1;
            b = b >>> 1;
        }
        return res;
    }

    public static int updateBit(int n, int i) {
        return n | (1 << i);
    }

    public static void main(String[] args) {
        System.out.println(add(10, 12));
    }
}
