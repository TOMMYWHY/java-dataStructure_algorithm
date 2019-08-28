package dataStructures.queue;

/**
 * Created by Tommy on 2019/8/28.
 */
public class LoopQueue {
    public int maxSize;
    public int front;
    public int rear;
    public int[] arr;

    public LoopQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        this.front = 0;
        this.rear = 0;
    }

    private boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front; // rear 下一个位置回到队头 且 与 front 相同, 则队列满
    }

     private boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("The queue is full now...");
            return;
        }
//        rear++;
        arr[this.rear] = n;
        this.rear = (this.rear + 1) % this.maxSize; //取模 是 rear 位置置于 front 前
    }

    public int popQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("The queue is empty now...");
        }
//        front++;
        int result = arr[front];
        this.front = (this.front + 1) % this.maxSize; //后移 取模 置队头。
        return result;
    }

    private int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("The queue is empty now...");
            return;
        }
        for (int i = this.front; i < front + this.size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }
    public int peekQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("The queue is empty now...");
        }
        return arr[front];
    }
}
