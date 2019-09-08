package algorithm01.sort.radix;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {3221, 1, 10, 9680, 577, 9420, 7, 5622, 4793, 2030, 3138, 82, 2599, 743, 4127};
//                     [10, 9680, 9420, 2030, 3221, 1, 5622, 82, 4793, 743, 577, 7, 4127, 3138, 2599]
        radix(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void radix(int[] arr) {

        int[][] bucket = new int[10][arr.length]; //二维数组 每一子项的大小 由 arr 长度决定。假定所有的数字都可放入一个桶中
        int[] buckElementCounts = new int[10]; //记录 桶中存在的 elements 数量

        int max = arr[0];
        //选择排序选出最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / (n) % 10; //个位，十位，百位的数值
                bucket[digitOfElement][buckElementCounts[digitOfElement]] = arr[j]; // 入桶：
//            System.out.println( "element: "+arr[j]+" ; "+"digitOfElement-个位数:"+digitOfElement+"  ;  "+"buckElementCounts[digitOfElement]:"+buckElementCounts[digitOfElement]);
                buckElementCounts[digitOfElement]++;//计数++
//            System.out.println(Arrays.toString(buckElementCounts));
            }
            int index = 0;
            for (int k = 0; k < buckElementCounts.length; k++) {
                //判断 桶中是否为空
                if (buckElementCounts[k] != 0) {
                    for (int l = 0; l < buckElementCounts[k]; l++) {
                        arr[index] = bucket[k][l] ;
                        index++;
                    }
                }
//            System.out.println(Arrays.toString(arr));///????
                System.out.println(Arrays.toString(buckElementCounts));
                buckElementCounts[k] = 0;
            }


        }


//++++++++++++++++++++++++++++++++++++++

/*        for (int j = 0; j < arr.length; j++) {
            int digitOfElement = arr[j]/10 % 10; //个位数值
            bucket[digitOfElement][buckElementCounts[digitOfElement]] = arr[j];
//            System.out.println( "element: "+arr[j]+" ; "+"digitOfElement-个位数:"+digitOfElement+"  ;  "+"buckElementCounts[digitOfElement]:"+buckElementCounts[digitOfElement]);

            buckElementCounts[digitOfElement]++;//计数++
//            System.out.println(Arrays.toString(buckElementCounts));
        }

         index = 0;
        for (int k = 0; k < buckElementCounts.length; k++) {
            //判断 桶中是否为空
            if (buckElementCounts[k] != 0) {
                for (int l = 0; l < buckElementCounts[k]; l++) {
                    arr[index] = bucket[k][l];
                    index++;
                }
            }
            System.out.println(Arrays.toString(arr));///????
        }
//        System.out.println(Arrays.toString(arr));*/
    }
}
