package algorithm01.sort.radix;

import java.util.Arrays;

public class RadixSortA {
    public static void main(String[] args) {
        int arr[] = {3221, 1, 10, 9680, 577, 9420, 7, 5622, 4793, 2030, 3138, 81, 2599, 743, 4127};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {


        int[][] matrix = new int[10][arr.length];
        int[] countingArr = new int[10];

        for (int i = 0,n=1; i < 4; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j]/(n) % 10;
                matrix[digitOfElement][countingArr[digitOfElement]] = arr[j];
                countingArr[digitOfElement] += 1;
            }
            int index = 0;
            for (int k = 0; k < countingArr.length; k++) {
                if (countingArr[k] != 0) {
                    for (int j = 0; j < countingArr[k]; j++) {
                        arr[index] = matrix[k][j];
                        index++;
                    }
                }
                countingArr[k] = 0 ; // 将计数数组制空。
            }
        }


        /*for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j] % 10;
            matrix[digitOfElement][countingArr[digitOfElement]] = arr[j];
            countingArr[digitOfElement] += 1;
        }
        int index = 0;
        for (int k = 0; k < countingArr.length; k++) {
            if (countingArr[k] != 0) {
                for (int j = 0; j < countingArr[k]; j++) {
                    arr[index] = matrix[k][j];
                    index++;
                }
            }
        }
*/
    }
}
