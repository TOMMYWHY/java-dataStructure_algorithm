package dataStructures.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s: show all stack");
            System.out.println("e: exit");
            System.out.println("p: push into stack");
            System.out.println("o: pop top out of stack");
            key = scanner.next();
            switch (key) {
                case "s":
                    arrayStack.list();
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    System.out.println("bye-bye~!");
                    break;
                case "p":
                    System.out.println("enter a number:");
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "o":
                    try {
                        int res = arrayStack.pop();
                        System.out.println(res + " pop out from stack");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
    }

}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int topIndex = -1; //游标

    protected ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    protected boolean isFull() {
        return topIndex == (this.maxSize - 1);
    }

    protected boolean isEmpty() {
        return topIndex == -1;
    }

    protected void push(int value) {
        if (isFull()) {
            System.out.println("stack is full");
        } else {
            topIndex++;
            stack[topIndex] = value;
        }
    }

    protected int pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        } else {
            int result = stack[topIndex];
            topIndex--;
            return result;
        }
    }

    protected void list() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        } else {
            for (int i = topIndex; i >= 0; i--) {
                System.out.printf("stack[%d] = %d\n", i, stack[i]);
            }
        }
    }
}
