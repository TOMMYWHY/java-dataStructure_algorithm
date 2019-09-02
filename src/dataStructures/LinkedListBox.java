package dataStructures;

/**
 * Created by Tommy on 2019/8/24.
 */
public class  LinkedListBox implements Box {
// 将 first 与 last 想象成 游标，不断移动。
    private Node first;
    private Node last;
    private int size;

    private void linkToLast(int element) {
        Node tailNode = this.last;
        Node newNode = new Node(tailNode, element, null);
        this.last = newNode;

        //判断 当前 为空链表。添加的 node 为第一个node
        if (tailNode == null) {
            first = newNode; //  first 与 last 指针位置都在 第一 node 上。
        } else {
            tailNode.next = newNode;
        }
        this.size++;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new BoxIndexOutOfBoundsException("index: " + index + " size:" + this.size);
        }
    }

    /*
    链的查找
    index 目标位置, 通过循环至index,使链向下移动,直到第 index 个 node。
    * */
    private Node findNode(int index) {
        Node targetNode;
        //双向查找 根据 index 与 size 的大小
        if (index < (this.size >> 1)) {
            targetNode = this.first;
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
            this.first = nextNode; //将要删除的下一个node 作为头
        } else {
            prevNode.next = nextNode;//将要删除 node 的上一个元素的 next 地址改为要删除 node 下一个元素
            targetNode.prev = null;
        }
        // 要删除的目标是最后一个 node
        if (nextNode == null) {
            this.last = prevNode; //将要删除的上一个node 作为尾
        } else {
            nextNode.prev = prevNode;
            targetNode.next = null;

        }
        size--;
        return oldValue;
    }

    @Override
    public boolean add(int element) {
        this.linkToLast(element);
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
