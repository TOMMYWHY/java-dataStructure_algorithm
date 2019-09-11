package algorithm01.sort.merge;

import java.util.Arrays;

public class MergeSortB {
    public static void main(String[] args) {
//        int[] arr = {1,4,7,8,3,6,9};
        int[] arr = {1, 4, 17, 88, 3, 16, 99};
        sort(arr,0,arr.length-1);
    }

    private static void sort(int arr[], int leftBound, int rightBound) {
        if(leftBound == rightBound) return;
        int mid = (leftBound+rightBound)/2;
//        int mid = leftBound + (rightBound - leftBound) / 2;
        sort(arr, leftBound,mid);
        sort(arr,mid+1,rightBound);
        merge(arr, leftBound,mid+1,rightBound);
    }

    private static void merge(int[] arr, int left, int right, int rightBound) {
        int mid = right - 1; // === leftBound
        int leftArrIndex = left;
        int rightArrIndex = right;
        int temp[] = new int[rightBound - left + 1];
        int tempIndex = 0;
        while (leftArrIndex <= mid && rightArrIndex <= rightBound) {
            if (arr[leftArrIndex] < arr[rightArrIndex]) {
                temp[tempIndex] = arr[leftArrIndex];
                tempIndex++;
                leftArrIndex++;
            } else {
                temp[tempIndex] = arr[rightArrIndex];
                tempIndex++;
                rightArrIndex++;
            }
        }
        while (leftArrIndex <= mid) {
            temp[tempIndex] = arr[leftArrIndex];
            tempIndex++;
            leftArrIndex++;
        }
        while (rightArrIndex <= rightBound) {
            temp[tempIndex] = arr[rightArrIndex];
            tempIndex++;
            rightArrIndex++;
        }
        System.out.println(Arrays.toString(temp));
    }
}
