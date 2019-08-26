package dataStructures;

/**
 * Created by Tommy on 2019/8/24.
 */
public class LinkedListBox implements Box {


    private Node first;
    private Node last;
    private int size;

    private void linkLast(int element) {
        Node l = last;
        Node newNode = new Node(l, element, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new BoxIndexOutOfBoundsException("index: " + index + " size:" + size);
        }
    }

    /*
    链的查找
    index 目标位置, 通过循环至index,使链向下移动,直到第 index 个 node。
    * */
    private Node findNode(int index) {
        Node targetNode;
        if (index < (size >> 1)) {
            targetNode = first;
            for (int i = 0; i < index; i++) {
                targetNode = targetNode.next;
            }
        } else {
            targetNode = last;
            for (int i = size - 1; i > index; i--) {
                targetNode = targetNode.prev;
            }

        }

        return targetNode;
    }

    private int unLink(Node targetNode) {

        int oldValue = targetNode.item;
        Node prevNode = targetNode.prev;
        Node nextNode = targetNode.next;
        //prevNode is first node.
        if (prevNode == null) {
            first = nextNode; //将要删除的下一个node 作为头
        } else {
            prevNode.next = nextNode;//将要删除 node 的上一个元素的 next 地址改为要删除 node 下一个元素
            targetNode.prev = null;
        }
        // 要删除的目标是最后一个 node
        if (nextNode == null) {
            last = prevNode; //将要删除的上一个node 作为尾
        } else {
            nextNode.prev = prevNode;
            targetNode.next = null;

        }
        size--;
        return oldValue;
    }

    @Override
    public boolean add(int element) {
        this.linkLast(element);
        return true;
    }

    @Override
    public int get(int index) {
        this.rangeCheck(index);
        Node targetNode = this.findNode(index);
        return targetNode.item;
    }

    @Override
    public int pop(int index) {
        this.rangeCheck(index);
        Node targetNode = findNode(index);
        int oldValue = this.unLink(targetNode);

        return oldValue;
    }

    @Override
    public int size() {
        return size;
    }
}
