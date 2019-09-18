package algorithm01.sort.heap;

public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
    }

    private static void sort(int[] arr) {
        System.out.println("heap sort");

    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 非叶子节点
        //k 是 i 的左子节点
        for (int k = (i * 2 + 1); k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 左< 右
                k++;
            }
            if(arr[k]>temp){ //左>父
                arr[i] = arr[k]; // 大只给 arr【i】
                i = k; // k 赋值给 i， 继续执行，有点想递归
            }else {break;}
        }
        arr[i] =temp;
    }

}
