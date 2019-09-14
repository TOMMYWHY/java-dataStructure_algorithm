package algorithm01.search.binary;

import java.util.Arrays;

public class InsertBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
        int resultIndex = search(arr, 0, arr.length - 1, 17);
        System.out.println(resultIndex);


    }

    private static int search(int[] arr, int left, int right, int findValue) {
        System.out.println("searching....");
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left+(right-left)*(findValue-arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];
        if (findValue < midValue) {
            return search(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {
            return search(arr, mid + 1, right, findValue);
        } else {
            return mid;
        }
    }
}
