package algorithm01.sort.bubble;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
//        bubble(arr);
        bubbleA(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleA(int[] arr) {
        for(int i = 0; i< arr.length-1; i++){
            for (int j = 0; j < arr.length -i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j,j+1);
                }
            }
        }

    }


    private static void bubble(int[] arr)  {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (flag == false) {
                break; // 一次都没交换过。
            } else {
                flag = false;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
