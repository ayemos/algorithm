import java.util.*;

public class StringBuffer {
    private List<Character> buffer;

    public StringBuffer() {
        this("");
    }

    public StringBuffer(String str) {
        this.buffer = new ArrayList<Character>();
        if(str != null && !str.equals("")) 
            this.buffer.addAll(str.toCharArray());
    }

    public void append(String str) {
        if(str != null && !str.equals("")) 
            this.buffer.add(str);
    }

    public void remove() {
        this.buffer.removeLast();
    }

    public String toString() {
    }
}
