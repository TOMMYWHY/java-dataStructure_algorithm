package algorithm01.sort.AVL_tree;

public class AvlTree {
    /*
     *   自平衡二叉查找树
     * 中序 traverse
     * */
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlBinaryTree avlBinaryTree = new AvlBinaryTree();
        for (int value : arr) {
            avlBinaryTree.add(new Node(value));
        }
        avlBinaryTree.inorderTraversal();
        System.out.println("check height ==========");
        System.out.println("tree    height:" + avlBinaryTree.getRoot().height());
        System.out.println("left height:" + avlBinaryTree.getRoot().leftHeight());
        System.out.println("right height:" + avlBinaryTree.getRoot().rightHeight());
        System.out.println("root:"+ avlBinaryTree.getRoot());
    }
}

class AvlBinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private Node searcher(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    private Node searchOfParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /*
     * @Param node 以 node 为 root （限定范围）
     * @return int  返回最小值 并 删除
     * */
    private int deleteRightTreeMin(Node node) {
        Node target = node;
        while (target.leftIndex != null) {
            target = target.leftIndex;
        }
        //target == min value
        deleteNode(target.value); //删除 从 node 开始 查找到的最小值
        return target.value;// return target
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = searcher(value);
            if (targetNode == null) {
                return;// 查找的值 不存在
            }
            // 没有被 return 说明 targetNode 找到
            if (root.leftIndex == null && root.rightIndex == null) { // 要删除 root 且 root 是唯一节点
                root = null;
                return;
            }
            Node parent = searchOfParent(value); // targetNode 的 parent
            if (targetNode.leftIndex == null && targetNode.rightIndex == null) { //targetNode 为叶子节点
                if (parent.leftIndex != null && parent.leftIndex.value == value) {
                    parent.leftIndex = null; // 删除 叶子节点
                } else if (parent.rightIndex != null && parent.rightIndex.value == value) {
                    parent.rightIndex = null; // 删除 叶子节点
                }
            } else if (targetNode.leftIndex != null && targetNode.rightIndex != null) { // target 有左右两个子节点

                int minValue = deleteRightTreeMin(targetNode.rightIndex);
                targetNode.value = minValue; // 左右都有子节点，将 右节点群中最小的(较大一侧的最小值) 替换成 target
                //        右节点群中最小的(较大一侧的最小值) 一定是最接近 且 大于 target.leftIndex 的值
                //        也可从左侧 找最大值，替换成 target
            } else { //target 有一个节点
                if (targetNode.leftIndex != null) {
                    //
                    if (parent != null) {
                        if (parent.leftIndex.value == value) { //|| parent.leftIndex == targetNode
                            parent.leftIndex = targetNode.leftIndex;
                        } else { //parent.rightIndex.value == value
                            parent.rightIndex = targetNode.leftIndex;
                        }
                    } else {
                        root = targetNode.leftIndex;
                    }
                } else { //targetNode.rightNode !=null
                    if (parent != null) {
                        if (parent.leftIndex == targetNode) { //parent.leftIndex.value == value ||
                            parent.leftIndex = targetNode.rightIndex;
                        } else {
                            parent.rightIndex = targetNode.rightIndex;
                        }
                    } else {
                        root = targetNode.rightIndex;
                    }
                }
            }
        }
    }

    public void add(Node newNode) {
        if (root == null) {
            this.root = newNode;
        } else {
            root.add(newNode);
        }
    }

    public void inorderTraversal() {
        if (root != null) {
            root.inorder();
        } else {
            System.out.println("tree is empty");
        }
    }
}


class Node {
    int value;
    Node leftIndex;
    Node rightIndex;

    public int leftHeight() {
        if (leftIndex == null) {
            return 0;
        } else {
            return leftIndex.height();
        }
    }

    public int rightHeight() {
        if (rightIndex == null) {
            return 0;
        } else {
            return rightIndex.height();
        }
    }

    public int height() {
        return Math.max(leftIndex == null ? 0 : leftIndex.height(), rightIndex == null ? 0 : rightIndex.height()) + 1;
    }

    // 左旋
    public void leftRotate() {
        Node newNode = new Node(value); //root value
        //newNode.left = root.left
        newNode.leftIndex = this.leftIndex;
        //newNode.right = root.right.left // 向下两层 即 root 右侧 较小值（ 与 root 左值 接近）
        newNode.rightIndex = this.rightIndex.leftIndex;
        //root.value = root.right.value // 由于 root.value 已经复制给 newNode，则可将 root.value 更改。实则交换。
        this.value = this.rightIndex.value;
        // root.right = root.right.right 让 root 的右 指向 下两层较大值
        this.rightIndex = this.rightIndex.rightIndex;
        //root.left = newNode
        this.leftIndex = newNode;
    }

    //右旋
    public void rightRotate() {
        Node newNode = new Node(value);
        newNode.rightIndex = this.rightIndex;
        newNode.leftIndex = this.leftIndex.rightIndex;
        this.value = this.leftIndex.value;
        this.leftIndex = this.leftIndex.leftIndex;
        this.rightIndex = newNode;

    }


    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) { //向左 recurse
            if (this.leftIndex != null) {
                return this.leftIndex.search(value);
            } else {
                return null;
            }
        } else {
            if (this.rightIndex != null) {
                return this.rightIndex.search(value);
            } else {
                return null;
            }
        }
    }

    public Node searchParent(int value) {
        if ((this.leftIndex != null && this.leftIndex.value == value) || (this.rightIndex != null && this.rightIndex.value == value)) {
            return this; // 儿子的值 == value
        } else {
            if (value < this.value && this.leftIndex != null) { // left recurse
                return this.leftIndex.searchParent(value);
            } else if (value >= this.value && this.rightIndex != null) {
                return this.rightIndex.searchParent(value);
            } else {
                return null; // 没有 找到 parentNode ，即 root
            }
        }
    }

    public void add(Node newNode) {
        // ???
        if (newNode == null) {
            return;
        }
        if (newNode.value < this.value) {
            if (this.leftIndex == null) {
                this.leftIndex = newNode;
            } else {
                this.leftIndex.add(newNode);//recurse
            }
        } else {
            if (this.rightIndex == null) {
                this.rightIndex = newNode;
            } else {
                this.rightIndex.add(newNode);
            }
        }
        // add 成功后 进行 高度检查
        if (rightHeight() - leftHeight() > 1) {
            if(rightIndex !=null && rightIndex.leftHeight() > rightIndex.rightHeight()){// 对左侧 高度 判断，
                rightIndex.rightRotate(); // 左侧 旋转
                this.leftRotate();//整体 旋转
            }else {
                this.leftRotate();
            }
           return;
        }


        if(leftHeight() - rightHeight() > 1){
            if(leftIndex !=null && leftIndex.rightHeight() > leftIndex.leftHeight()){// 对左侧 高度 判断，
                leftIndex.leftRotate(); // 左侧 旋转
                this.rightRotate();//整体 旋转
            }else {
                this.rightRotate();
            }
            return;
        }
    }

    public void inorder() {
        if (this.leftIndex != null) {
            this.leftIndex.inorder();
        }
//        System.out.println(this);
        System.out.println(this.value);
        if (this.rightIndex != null) {
            this.rightIndex.inorder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftIndex=" + leftIndex +
                ", rightIndex=" + rightIndex +
                '}';
    }

}