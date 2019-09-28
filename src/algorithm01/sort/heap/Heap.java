package algorithm01.sort.heap;

import java.util.Arrays;

/**
 * 大顶堆
 */
public class Heap {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9,-1,90,2,-8};
        sort(arr);
    }

    private static void sort(int[] arr) {
     /*   System.out.println("heap sort");
        adjustHeap(arr,1,arr.length);
        System.out.println(Arrays.toString(arr));
        adjustHeap(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));*/
     for (int i = arr.length/2 -1 ; i >=0;i--){
         adjustHeap(arr,i,arr.length);
     }
        System.out.println(Arrays.toString(arr));
     int temp = 0;
     for(int j = arr.length-1;j>0;j--){
        temp= arr[j];
        arr[j] = arr[0];
        arr[0]= temp;
         adjustHeap(arr,0,j);

     }
        System.out.println(Arrays.toString(arr));
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i]; // 非叶子节点
        //k 是 i 的左子节点
        for (int k = (i * 2 + 1); k < length; k = k * 2 + 1) {
//            选出 左右 较大的下标。 只需找到左右中一个大的值 与 父节点交换
            if (k + 1 < length && arr[k] < arr[k + 1]) { // 左< 右
                k++; // k 为 右子节点 下标
            }
            if(arr[k]>temp){ //右or 左 >父
                arr[i] = arr[k]; // 大值给 arr【i】
                i = k; // k 赋值给 i， 继续执行，有点向递归
            }else {break;}
        }
        arr[i] =temp;
    }

}
