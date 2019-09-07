package algorithm01.sort.selection;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 9, 6, 11};
//        select(arr);
        selectA(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectA(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos] ? j : minPos;
               /* if (arr[j] < arr[minPos]) {
                    minPos = j;
                }*/
            }
          swap(arr,i,minPos);
            System.out.println("minPos"+minPos);
        }


    }
    private static void swap(int[] arr,int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void select(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
