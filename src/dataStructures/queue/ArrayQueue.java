package dataStructures.queue;

/**
 * Created by Tommy on 2019/8/27.
 */
public class ArrayQueue {
    public int maxSize;
    public int front;
    public int rear;
    public int[] arr; // = new int[this.maxSize];

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return this.rear == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return this.rear == this.front;
    }

    public void addQueue(int n) {
        if (this.isFull()) {
            System.out.println("The queue is full now...");
            return;
        }
        rear++;
        arr[rear] = n;

    }

    public int popQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("The queue is empty now...");
        }
        front++;
        int result = arr[front];
        arr[front] = 0;
        return result;
    }

    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("The queue is empty now...");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int peekQueue() {
        if (this.isEmpty()) {
            throw new RuntimeException("The queue is empty now...");
        }
        return arr[front + 1];
    }

}
