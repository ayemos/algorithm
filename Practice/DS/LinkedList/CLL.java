public class CLL {
    private class Node {
        Node next;
        int value;
    }

    private Node head;

    public void insert(int p, int value) throws Exception {
        Node node = new Node();
        node.value = value;
        if(head == null) {
            if(p == 0) {
                head = node;
                node.next = node;
            } else {
                throw new Exception("Out of range!");
            }
        } else {
            if(p == 0) {
                Node tmp = head;
                while(tmp.next != head) 
                    tmp = tmp.next;
                tmp.next = node;
                node.next = head;
                head = node;
            } else {
                Node tmp = head;
                int i = 0;
                while(tmp.next != head && i < p - 1) {
                    tmp = tmp.next;
                    i++;
                }

                if(i == p - 1) {
                    node.next = tmp.next;
                    tmp.next = node;
                } else {
                    throw new Exception("Out of range!");
                }
            }
        }
    }

    public void remove(int p) {
    }

    public String toString() {
        if(head == null) {
            return "[]";
        } else {
            // head != null
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            Node tmp = head;
            while(true) {
                sb.append(tmp.value + ", ");
                tmp = tmp.next;
                if(tmp == head)
                    break;
            }

            if(sb.length() > 2) 
                sb.setLength(sb.length() - 2);
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        CLL cll = new CLL();
        System.out.println(cll);
        cll.insert(0, 5);
        cll.insert(1, 3);
        cll.insert(1, 2);
        cll.insert(2, 4);
        System.out.println(cll);
    }
}
