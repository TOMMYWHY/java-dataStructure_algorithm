package algorithm01.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 9, 6, 11};

        insert(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i]; //从第二个数开始比对
            int insertPervIndex = i - 1; // insertValue 前一个位置
            while (insertPervIndex >= 0 && insertValue < arr[insertPervIndex]) { //每次循环 insertValue 与前一个数字比对
                arr[insertPervIndex + 1] = arr[insertPervIndex]; // 将 前一个数赋值给 inservalue 位置上
                insertPervIndex--;
            }
            if(insertPervIndex +1 != i){
                arr[insertPervIndex + 1] = insertValue;//insertIndex 值为 -1 //跳出循环后的情况， inservalue 大于前一个数，则 inservalue 放在后面。
            }
        }


    }
}
