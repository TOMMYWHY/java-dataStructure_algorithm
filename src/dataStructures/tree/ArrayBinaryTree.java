package dataStructures.tree;

public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrayBinaryTree =  new ArrBinaryTree(arr);
        arrayBinaryTree.preOrderStore();

    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrderStore(){
        this.preOrderStore(0);
    }

    public void preOrderStore(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("array is empty");
        }else {
            System.out.println(arr[index]);
            if((index*2+1) <arr.length){
                preOrderStore(2*index +1); //left
            }
            if((index*2+2) <arr.length){
                preOrderStore(2*index +2); //right
            }
        }

    }
}