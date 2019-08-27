package dataStructures.queue;

import java.util.Scanner;

/**
 * Created by Tommy on 2019/8/27.
 */
public class TestMain {
    public static void main(String[] args) {
        ArrayQueue arr = new ArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s:show queue.");
            System.out.println("e:exit.");
            System.out.println("a:add queue.");
            System.out.println("p:pop queue..");
            System.out.println("h:peek queue.");

            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arr.showQueue();
                    break;
                case 'a':
                    System.out.println("enter a number:");
                    int value = scanner.nextInt();
                    arr.addQueue(value);
                    break;
                case 'p':
                    try {
                        int res = arr.popQueue();
                        System.out.printf("get number from queue %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arr.peekQueue();
                        System.out.printf("peek number from queue %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("bye-bye~!");
                    break;
                default:
                    break;
            }
        }

        arr.showQueue();//empty
        arr.addQueue(2);
        arr.addQueue(4);
        arr.showQueue();
    }
}
