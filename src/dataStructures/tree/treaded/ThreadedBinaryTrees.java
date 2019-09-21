package dataStructures.tree.treaded;

public class ThreadedBinaryTrees {
    /*
    空指针域： 2n-(n-1) = n+1
    前驱结点，后继结点 01
      */

    public static void main(String[] args) {
        int[] arr = {8,3,10,1,14,6};
        Node root = new Node(1,"a");
        Node node2 = new Node(3,"b");
        Node node3 = new Node(6,"c");
        Node node4 = new Node(8,"d");
        Node node5 = new Node(10,"e");
        Node node6 = new Node(14,"f");

        root.setLeftIndex(node2);
        root.setRightIndex(node3);
        node2.setLeftIndex(node4);
        node2.setRightIndex(node5);
        node3.setLeftIndex(node6);
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);
        binaryTree.threadedNodes();

//        testing
        Node left =  node5.getLeftIndex();
        Node right =  node5.getRightIndex();
        System.out.println(node5.toString());
        System.out.println("leftNode"+left);
        System.out.println("rightNode"+right);
    }

}

class BinaryTree {
    private Node root;
    private Node pre = null; //前一个节点，中序遍历中的前一个节点，即this.node 的 左子节点。

    public void setRoot(Node root) {
        this.root = root;
    }
    public void threadedNodes( ){
        this.threadedNodes(root);
    }
/*
* 中序线索
* */
    public void threadedNodes(Node node){
        if (node ==null){
            return;
        }
        threadedNodes(node.getLeftIndex());
        if(node.getLeftIndex()==null){
            node.setLeftIndex(pre);
            node.setLeftType(1); //该 node 的 leftIndex 指向 前驱节点
        }

        //后继节点， 是node 的上一层的父节点 来对 type 操作
        if(pre!=null && pre.getRightIndex()==null){  //this.node 的 左子节点 rightIndex 指向 this.node
            pre.setRightIndex(node);
            pre.setRightType(1); // 此时的 pre 是 前驱节点
        }
        pre = node;//????

        threadedNodes(node.getRightIndex());


    }

    public void delNode(int id){
        if (root !=null){
            if(root.getId() == id){
                root = null;
            }else {
                root.deleteNode(id);
            }
        }else {
            System.out.printf("tree is empty");
        }
    }
    public void preOrdering() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("tree is empty");
        }
    }

    public Node preOrderSearcher(int id) {
        if (root != null) {
            return root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    public void infixOrdering() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("tree is empty");
        }
    }

    public Node infixOrderSearcher(int id) {
        if (root != null) {
            return root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    public void postOrdering() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("tree is empty");
        }
    }


}

 class Node {
    private int id;
    private String name;
    private Node leftIndex;
    private Node rightIndex;
    private int leftType;// ==0 left tree； ==1 前驱节点
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public void deleteNode(int id ){
        if (this.leftIndex != null && this.leftIndex.id == id){
            this.leftIndex =null;
            return;
        }
        if(this.rightIndex !=null && this.rightIndex.id == id){
            this.rightIndex=null;
            return;
        }
        if(this.leftIndex !=null){
            this.leftIndex.deleteNode(id);
        }
        if(this.rightIndex !=null){
            this.rightIndex.deleteNode(id);
        }

    }

    /*
    Preorder Traversal  DLR
     */

    public void preOrder() {
        System.out.println(this);//output root node
        if (this.leftIndex != null) {
            this.leftIndex.preOrder();
        }
        if (this.rightIndex != null) {
            this.rightIndex.preOrder();
        }
    }

    public Node preOrderSearch(int id) {
        System.out.println("searching.......");
        if (this.id == id) {
            return this;
        }
        Node resultNode = null;
        if (this.leftIndex != null) {
            resultNode = this.leftIndex.preOrderSearch(id);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.rightIndex != null) {
            resultNode = this.rightIndex.preOrderSearch(id);
        }

        return resultNode;

    }

    /*
    Inorder Traversal (LDR)
     */
    public void infixOrder() {
        if (this.leftIndex != null) {
            this.leftIndex.infixOrder();
        }
        System.out.println(this);
        if (this.rightIndex != null) {
            this.rightIndex.infixOrder();
        }
    }

    public Node infixOrderSearch(int id) {
        Node resultNode = null;
        if (this.leftIndex != null) {
            resultNode = this.leftIndex.infixOrderSearch(id);
        }
        if (resultNode != null) {
            return resultNode;
        }
        if (this.id == id) {
            return this;
        }
        if (this.rightIndex != null) {
            resultNode = this.rightIndex.infixOrderSearch(id);
        }
        return resultNode;
    }

    /*
    Postorder Traversal (LRD)
     */
    public void postOrder() {
        if (this.leftIndex != null) {
            this.leftIndex.postOrder();
        }
        if (this.rightIndex != null) {
            this.rightIndex.postOrder();
        }

        System.out.println(this);

    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Node(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(Node leftIndex) {
        this.leftIndex = leftIndex;
    }

    public Node getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(Node rightIndex) {
        this.rightIndex = rightIndex;
    }
}