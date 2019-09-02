package s01.arrays;

import java.util.Stack;

public class ReverseArr {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        /*
        * 数组不可变，反转两种方式：
        *                       1. for
        *                       2. stack
        * */

        /*reverseFor(arr);
        for(int item : arr){
            System.out.printf("%d ;",item);
        }*/


        reverseStack(arr);
    }

    protected static void reverseFor(int[] arr){
        for (int i = 0; i < (arr.length/2); i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i -1];
            arr[arr.length - i -1] = temp;
        }
    }

    protected static void reverseStack (int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int item: arr){
            stack.push(item);
        }
        while (stack.size()>0){
            System.out.printf("%d -",stack.pop());
        }
    }
}
