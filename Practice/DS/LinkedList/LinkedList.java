import java.util.Set;
import java.util.HashSet;

public class LinkedList {
    private class Node {
        Node next;
        int value;
        public String toString() {
            return Integer.toString(value);
        }
    }

    private Node head;

    public void insert(int p, int value) throws Exception {
        Node node = new Node();
        node.value = value;

        if(p == 0) {
            node.next = head;
            head = node;
        } else {
            Node tmp = head;
            int c = 0;
            while(tmp != null && c < p - 1)  {
                c++;
                tmp = tmp.next;
            }
            
            if(c == p - 1) {
                node.next = tmp.next;
                tmp.next = node;
            } else {
                throw new Exception("Out of range!");
            }
        }
    }

    public void remove(int p) throws Exception {
        if(head == null) {
            throw new Exception("Empty!");
        } else {
            if(p == 0) {
                head = head.next;
            } else {
                Node tmp = head;
                for(int i = 0; i < p - 1; i++) 
                    if(tmp != null)
                        tmp = tmp.next;
                    else
                        throw new Exception("Out of range!");

                if(tmp != null && tmp.next != null) 
                    tmp.next = tmp.next.next;
                else 
                    throw new Exception("Out of range!");
            }
        }
    }

    public Node nthNodeFromLast(int n) throws Exception {
        Node tmp = head;
        while((tmp != null) && n > 0) {
            tmp = tmp.next;
            n--;
        }

        if(tmp == null) {
            throw new Exception("Out of range!");
        } else {
            Node nth = head;
            while(tmp.next != null) {
                tmp = tmp.next;
                nth = nth.next;
            }

            return nth;
        }
    } 
    
    public String toString() {
        if(head == null)
            return "";
        else {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            Node tmp = head;
            while(tmp != null) {
                sb.append(tmp.value + ", ");
                tmp = tmp.next;
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
            return sb.toString();
        }
    }

    public void insertToSortedList(int value) {
        Node node = new Node();
        node.value = value;
        if(head == null) {
            head = node;
        } else {
            if(head.value > value) {
                node.next = head;
                head = node;
            } else {
                Node tmp = head;
                while(tmp.next != null && tmp.next.value < value) 
                    tmp = tmp.next;// tmp won't be null;

                node.next = tmp.next;
                tmp.next = node;
            }
        }
    }

    public void reverse() {
        this.head = reverseSub(head);
    }

    public Node reverseSub(Node head) {
        // head以下を反転し、headを返す
        if(head == null) {
            return null;
        } else if(head.next == null) {
            // 1個
            return head;
        } else {
            Node nextNode = head.next;
            Node newHead = reverseSub(nextNode);
            head.next = null;
            nextNode.next = head;
            return newHead;
        }
    }

    public Node findMiddle() {
        Node fast = head;
        Node slow = head;
        while(true) {
            if(fast.next == null) 
                return slow;
            else
                fast = fast.next;

            if(fast.next == null) {
                return slow;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
    }

    public void printReverse() {
        printReverseSub(head);
    }

    private void printReverseSub(Node head) {
        if(head == null) {
            return;
        } else {
            printReverseSub(head.next);
            System.out.println(head.value);
        }
    }

    public boolean isOdd() {
        boolean res = true;
        Node tmp = head;
        while(tmp != null) {
            tmp = tmp.next;
            res = !res;
        }
        return res;
    }

    public boolean isEven() {
        return !isOdd();
    }

    public void removeDups() {
        if(head == null || head.next == null) {
            return;
        } else {
            Node p = head;
            Set<Integer> memo = new HashSet<Integer>();
            memo.add(p.value);
            while(p.next != null) {
                if(memo.contains(p.next.value)) {
                    p.next = p.next.next;
                } else {
                    memo.add(p.next.value);
                    p = p.next;
                }
            }
        }
    }

    public void removeDups2() {
        if(head == null || head.next == null) {
            return ;
        } else {
            Node tmp, p;
            int v;
            p = head;
            while(p.next != null) {
                tmp = p;
                v = tmp.value;
                while(tmp.next != null) {
                    if(tmp.next.value == v)
                        tmp.next = tmp.next.next;
                    else 
                        if(tmp.next != null) 
                            tmp = tmp.next;

                }
                p = p.next;
            }
        }
    }

    public Node lastKthNode(int k) throws Exception {
        Node p, q;
        p = head;
        q = head;
        while(k > 0 && q.next != null) {
            q = q.next;
            k--;
        }

        if(k != 0)
            throw new Exception("Out of bound");

        while(q != null) {
            q = q.next;
            p = p.next;
        }

        return p;
    }

    public void moveSmallerThan(int n) {
        if(head == null) 
            return;

        Node tmp = head;
        Node next;
        while(tmp.next != null) {
            if(tmp.next.value < n) {
                next = tmp.next;
                tmp.next = next.next;
                next.next = head;
                head = next;
            } else {
                if(tmp.next != null)
                    tmp = tmp.next;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LinkedList list = new LinkedList();
        System.out.println(list);
        list.insert(0, 5);
        list.insert(0, 2);
        list.insert(0, 3);
        list.insert(0, 2);
        list.insert(0, 2);
        list.insert(0, 4);
        System.out.println(list);
        list.moveSmallerThan(3);
        System.out.println(list);
        list.moveSmallerThan(4);
        System.out.println(list);

    }
}
