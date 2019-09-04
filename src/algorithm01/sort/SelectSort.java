package algorithm01.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 9, 6, 11};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void select(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j< arr.length-i; j++ ){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
