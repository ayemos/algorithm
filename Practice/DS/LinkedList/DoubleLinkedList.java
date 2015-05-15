public class DoubleLinkedList {
    class DLLNode {
        DLLNode next;
        int value;
    }

    DLLNode head;
    
    public void insert(int value, int p) throws Exception {
        ListNode node = new ListNode();
        node.value = value;

        if(p == 0) {
            node.next = head;
            head = node;
        } else {
            ListNode tmp = head;
            for(int i = 0; i < p - 1; i++) {
                if(tmp.next != null) {
                    tmp = tmp.next;
                } else {
                    throw new Exception("Out of Range!");
                }
            }
            node.next = tmp.next;
            tmp.next = node;
        }
    }

    public void remove(int p) throws Exception {
        if(p == 0) {
            if(head != null)
                head = head.next;
            else 
                throw new Exception("Out of Range!");
        } else {
            ListNode tmp = head;
            for(int i = 0; i < p - 1; i++) 
                if(tmp.next != null) 
                    tmp = tmp.next;
                else
                    throw new Exception("Out of Range!");

            tmp.next = tmp.next.next;
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");

        ListNode node = head;
        while(node != null) {
            sb.append(node.value);
            sb.append(", ");
            node = node.next;
        }

        if(sb.length() > 1) 
            sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        try {
            System.out.println(list);
            list.insert(5, 0);
            list.insert(3, 1);
            list.insert(2, 2);
            list.insert(4, 1);
            System.out.println(list);
            list.remove(3);
            list.remove(0);
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

