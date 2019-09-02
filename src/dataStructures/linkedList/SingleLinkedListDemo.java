package dataStructures.linkedList;


import javax.xml.ws.Holder;
import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode h1 = new HeroNode(1, "a", "aa");
        HeroNode h2 = new HeroNode(2, "b", "bb");
        HeroNode h3 = new HeroNode(3, "c", "cc");
        HeroNode h4 = new HeroNode(4, "d", "dd");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOdder(h1);
        singleLinkedList.addByOdder(h3);
        singleLinkedList.addByOdder(h4);
        singleLinkedList.addByOdder(h2);
        singleLinkedList.list();
        System.out.println();
        HeroNode newNode = new HeroNode(2, "bbb", "bbbbbbbb");
        singleLinkedList.update(newNode);

        singleLinkedList.list();

        int length = singleLinkedList.getLength(singleLinkedList.getHead());
        System.out.println(length);

        System.out.println("=============reverseList================");
        singleLinkedList.reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println();
        System.out.println("=============reversePrint================");

        singleLinkedList.reversePrint(singleLinkedList.getHead());
    }
}

class HeroNode {
    protected int no;
    protected String name;
    protected String nickName;
    protected HeroNode next;

    protected HeroNode(int no, String name, String nickName) {
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

  class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    protected HeroNode getHead() {
        return this.head;
    }

    protected void add(HeroNode newNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next; //***
            }
            ;
        }
        temp.next = newNode;
    }

    protected void addByOdder(HeroNode newNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break; //查看 temp 是否为头，是头则无需循环
            }
            if (temp.next.no > newNode.no) {
                break;  // 找到 位置
            } else if (temp.next.no == newNode.no) {
                flag = true;   // 存在相同编号
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("exist same No. %d", newNode.no);
        } else {
            newNode.next = temp.next; //**
            temp.next = newNode; //**

        }
    }

    protected void update(HeroNode node) {
        if (head.next == null) {
            System.out.println("list is empty");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.no == node.no) {
                flag = true;
                break;
            } else {
                temp = temp.next;
            }
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
//            node.next = temp.next;
//            temp.next = node;
        } else {
            System.out.printf("cannot found no. %d info", node.no);
        }

    }

    protected int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        } else {
            int length = 0;
            HeroNode cur = head.next;
            while (cur != null) {
                cur = cur.next;
                length++;
            }
            return length;
        }
    }

    protected void list() {
        if (this.head.next == null) {
            System.out.println("list is empty");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
            ;
        }


    }

    protected void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            System.out.println("not need reverse");
        } else {
            HeroNode cur = head.next;
            HeroNode next = null;
            HeroNode reverseHead = new HeroNode(0, "", "");
            while (cur != null) {
                next = cur.next;
                cur.next = reverseHead.next;
                reverseHead.next = cur;//新 链表 连接起来
                cur = next;
            }
            head.next = reverseHead.next;
        }

    }

    protected void reversePrint(HeroNode head) {
        if (head.next != null) {
            Stack<HeroNode> stack = new Stack<>();
            HeroNode cur = head.next;
            while (cur != null) {
                stack.push(cur);
                cur = cur.next;
            }
            while (stack.size() > 0) {
                System.out.println(stack.pop());
            }
        } else {
            System.out.println("its empty");
        }
    }

}
