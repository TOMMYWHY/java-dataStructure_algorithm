package algorithm01.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 9, 6, 11, 55, 4};
        shell(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shell(int[] arr) {
//        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
               /* for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }*/
                int j = i;
                int temper = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temper < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = temper;
                }
            }
        }

    }
}
