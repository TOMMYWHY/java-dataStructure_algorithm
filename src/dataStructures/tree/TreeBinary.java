package dataStructures.tree;

/**
 * https://www.bilibili.com/video/av59600020/?p=97
 */
public class TreeBinary {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");

        root.setLeftIndex(node2);
        root.setRightIndex(node3);
        node3.setRightIndex(node4);
        node3.setLeftIndex(node5);
        System.out.println("preOrder");

        binaryTree.setRoot(root);
        binaryTree.preOrdering();
        Node resNode = binaryTree.preOrderSearcher(3);
        if (resNode != null) {
            System.out.println("searching result : " + resNode.toString());
        }

//        System.out.println("infixOrder");
//        binaryTree.infixOrdering();
//
//        System.out.println("postOrder");
//        binaryTree.postOrdering();

    }


}

class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
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
