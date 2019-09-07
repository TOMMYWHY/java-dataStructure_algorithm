package algorithm01.sort.merge;

import java.util.Arrays;

/*
Todo

 */
public class MergeSortA {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        int[] arr = {1, -5, -9, -3, -8, 7, 0, 6, 11, -55, 4};

//        sort(arr, 0, arr.length - 1);
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2; //防止超出 int 范围
        sort(arr, left, mid);
        sort(arr, mid + 1, right);
        merge(arr, left, mid + 1, right);
    }

    private static void merge(int[] arr, int leftPtr, int rightPtr, int rightBound) {
        int mid = rightPtr - 1;
        int[] temp = new int[rightBound - leftPtr + 1];
        int i = leftPtr; // left part index0
        int j = rightPtr; //right part index0
        int k = 0; //temp index0

        while (i <= mid && j <= rightBound) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arr[j++];

        }
//        System.out.println(Arrays.toString(temp));
        for (int m = 0; m < temp.length; m++) {
            arr[leftPtr + m] = temp[m];
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
