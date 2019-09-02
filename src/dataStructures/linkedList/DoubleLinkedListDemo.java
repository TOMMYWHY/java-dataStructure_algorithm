package dataStructures.linkedList;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Node h1 = new Node(1, "a", "aa");
        Node h2 = new Node(2, "b", "bb");
        Node h3 = new Node(3, "c", "cc");
        Node h4 = new Node(4, "d", "dd");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(h1);
        doubleLinkedList.add(h3);
        doubleLinkedList.add(h4);
        doubleLinkedList.add(h2);
        doubleLinkedList.list();
    }
}

class DoubleLinkedList{
    private Node head = new Node(0, "", "");
    protected Node getHead() {
        return this.head;
    }

    protected void list(){
        if(head.next !=null){
            Node temp = head.next;
            while (temp != null){
                System.out.println(temp);
                temp = temp.next;
            }
        }else {
            System.out.println("list is empty");
        }
    }

    protected void add( Node newNode){
        if(head.next == null){
            head.next = newNode;
            newNode.pre = head;
        }else {
            Node temp = head.next;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.pre = temp;
        }
    }

    protected void delete(Node targetNode){

    }

}

class Node {
    protected int no;
    protected String name;
    protected String nickName;
    protected Node next;
    protected Node pre;

    protected Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
//            this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}