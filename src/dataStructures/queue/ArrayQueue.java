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

    public boolean isEmpty(){
        return this.rear == this.front;
    }

    public int[] addQueue(int n){
        if(this.isFull()){
            System.out.println("The queue is full now...");

        }else{
            rear ++;
            arr[rear] = n;
        }
        return this.arr;
    }

}
