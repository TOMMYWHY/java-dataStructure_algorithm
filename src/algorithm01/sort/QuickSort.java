package algorithm01.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, -5, -9, -3, -8, 7, 0, 6, 11, -55, 4};
        quick(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l+=1;
            }
            while (arr[r] > pivot) {
                r-=1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            } else if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quick(arr, left, r);
        }
        if (l < right) {
            quick(arr, l, right);
        }


    }
}
