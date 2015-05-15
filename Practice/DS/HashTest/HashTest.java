import java.util.*;

public class HashTest {
    class BadObject {
        private int value;
        public BadObject(int value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            if(o instanceof BadObject) {
                return ((BadObject) o).value == value;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return 0;
        }
    }

    class GoodObject {
        private int value;
        public GoodObject(int value) {
            this.value = value;
        }

        public boolean equals(Object o) {
            if(o instanceof GoodObject) {
                return ((GoodObject) o).value == value;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return value;
        }
    }

    public void run() {
        int n = 50000;
        long start, stop;

        Map<BadObject, Integer> map = new HashMap<BadObject, Integer>();
        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) 
            map.put(new BadObject(i), i);

        for(int i = 0; i < n; i++)
            map.get(i);
        stop = System.currentTimeMillis();

        System.out.println("BadCase: " + (stop - start));

        Map<GoodObject, Integer> map2 = new HashMap<GoodObject, Integer>();
        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            map2.put(new GoodObject(i), i);

        for(int i = 0; i < n; i++)
            map2.get(i);
        stop = System.currentTimeMillis();

        System.out.println("NormalCase: " + (stop - start));
    }

    public static void main(String[] args) {
        new HashTest().run();
    }
}




