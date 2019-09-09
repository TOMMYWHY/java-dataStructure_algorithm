package algorithm01.sort.insertion;

import java.util.Arrays;

public class inserSortA {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 9, 6, 11};

//        insert(arr);
        insertA(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void insertA(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int currentIndexValue = arr[i];
            int preIndex = i - 1;
            while (preIndex >= 0 && arr[preIndex] > currentIndexValue) {
                System.out.println(preIndex);
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = currentIndexValue;
            // preIndex 每次循环都-- 跳出循环前又-- 一次，所以 preIndex +1 ！= i

        }
    }

    private static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}