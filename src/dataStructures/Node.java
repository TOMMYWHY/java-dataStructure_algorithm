package dataStructures;

/**
 * Created by Tommy on 2019/8/24.
 */
public class Node {
    public Node prev;
    public int item;
    public Node next;

    public Node(Node prev, int item, Node next) {
        this.prev = prev;
        this.item = item;
        this.next = next;
    }
}
