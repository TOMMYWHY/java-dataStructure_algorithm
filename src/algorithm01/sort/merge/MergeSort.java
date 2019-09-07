package algorithm01.sort.merge;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, -5, -9, -3, -8, 7, 0, 6, 11, -55, 4};
        int[] temp = new int [ arr.length];
        mergeS(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeS(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeS(arr, left, mid, temp);
            mergeS(arr, mid + 1, right, temp);
            merge(arr,left,right,mid,temp);
        }
    }

    private static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        System.out.println("*");
        int i = left;
        int j = mid + 1;
        int t = 0; //temp 的 游标
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }


    }


}
