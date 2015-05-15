public class DLL {
    private class Node {
        Node prev, next;
        int value;
    }

    private Node head;

    public void insert(int p, int value) throws Exception {
        Node node = new Node();
        node.value = value;

        if(p == 0) {
            if(head != null) 
                head.prev = node;
            node.next = head;
            head = node;
        } else {
            Node tmp = head;
            
            for(int i = 0; i < p - 1; i++) 
                if(tmp != null)
                    tmp = tmp.next;
                else
                    throw new Exception("Out of range!");

            if(tmp != null) {
                node.prev = tmp;
                node.next = tmp.next;
                if(tmp.next != null) 
                    tmp.next.prev = node;
                tmp.next = node;
            } else {
                throw new Exception("Out of range!");
            }
        }
    }

    public void remove(int p) throws Exception {
        if(head == null)
            throw new Exception("Empty!");

        if(p == 0) {
            if(head.next != null) 
                head.next.prev = null;
            head = head.next;
        } else {
            Node tmp = head;
            for(int i = 0; i < p - 1; i++) 
                if(tmp != null)
                    tmp = tmp.next;
                else
                    throw new Exception("Out of range!");

            if(tmp != null && tmp.next != null) {
                if(tmp.next.next != null)
                    tmp.next.next.prev = tmp;
                tmp.next = tmp.next.next;
            } else {
                throw new Exception("Out of range!");
            }
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node tmp = head;
        while(tmp != null) {
            sb.append(tmp.value + ", ");
            tmp = tmp.next;
        }

        if(sb.length() > 2)
            sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        DLL dll = new DLL();
        System.out.println(dll);
        dll.insert(0, 5);
        dll.insert(1, 3);
        dll.insert(0, 4);
        dll.insert(2, 2);
        System.out.println(dll);
        dll.remove(3);
        System.out.println(dll);
        dll.remove(0);
        System.out.println(dll);
        dll.remove(1);
        System.out.println(dll);
        dll.remove(0);
        System.out.println(dll);
    }
}
