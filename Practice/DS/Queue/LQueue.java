public class LQueue {
    private class Node {
        Node next;
        int value;
    }

    private Node head, tail;

    public void enqueue(int value) {
        Node node = new Node();
        node.value = value;
        if(tail == null) { 
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue() throws Exception {
        if(head == null) {
            throw new Exception("Empty!");
        } else {
            Node ret = head;
            head = head.next;
            if(head == null)
                tail = null;
            return ret.value;
        }
    }

    public static void main(String[] args) throws Exception {
        LQueue lq = new LQueue();
        lq.enqueue(5);
        lq.enqueue(3);
        lq.enqueue(2);
        lq.enqueue(4);
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        lq.enqueue(5);
        lq.enqueue(3);
        lq.enqueue(2);
        lq.enqueue(4);
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
        System.out.println(lq.dequeue());
    }
}




