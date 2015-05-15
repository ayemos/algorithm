public class Queue {
    private int[] queue;
    private int head, tail, cap;

    public Queue(int cap) {
        this.cap = cap;
        queue = new int[cap];
        head = -1;
        tail = -1;
    }

    public void enqueue(int value) throws Exception {
        if(head == -1) {
            queue[0] = value;
            head = 0;
            tail = 0;
        } else if((tail + 1) % cap == head) {
            throw new Exception("Over capacity!");
        } else {
            queue[++tail] = value;
        }
    }

    public int dequeue() throws Exception {
        if(head == -1) {
            throw new Exception("Empty!");
        } else {
            int ret = queue[head];
            if(head == tail) {
                head = -1;
                tail = -1;
            } else {
                head++;
            }
            return ret;
        }
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue(10);
        for(int i = 0; i < 11; i++) 
            queue.enqueue(i);
    }
}
