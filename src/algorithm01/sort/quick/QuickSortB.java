package algorithm01.sort.quick;

import java.util.Arrays;

public class QuickSortB {
    public static void main(String[] args) {
        int[] arr = {2, -5, -9, -3, -8, 7, -1, 6, 11, -55, 4};
        quick(arr, 0, arr.length - 1);
//         int pivot =  partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        System.out.println(pivot);
    }

    private static void quick(int arr[], int leftBound, int rightBound) {
        int mid = partition( arr,  leftBound,  rightBound);
        partition(arr,leftBound,mid-1);
        partition(arr,mid+1,rightBound);


    }

    private static int partition(int[] arr, int leftBound, int rightBound) {
        int pivot = arr[leftBound];
        int leftIndex = leftBound + 1;
        int rightIndex = rightBound;
        while (leftIndex < rightIndex) {
            while (leftIndex <= rightIndex && arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (leftIndex <= rightIndex && arr[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                int temp = arr[leftIndex];
                arr[leftIndex] = arr[rightIndex];
                arr[rightIndex] = temp;
            }
        }
        int temp = arr[rightIndex];
        arr[rightIndex] = arr[leftBound];// 此处赋值不能使用 pivot，而是 数组索引的值。
        arr[leftBound] = temp;

        return rightIndex;
    }
}
