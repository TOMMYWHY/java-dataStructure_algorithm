package algorithm01.search.fibonacci;

import java.util.Arrays;
import java.util.WeakHashMap;

public class FibonacciSearch {
    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 7, 7, 7, 10, 81, 577, 743, 2030, 2599, 3138, 3221, 4127, 4793, 5622, 9420, 9680};
        int result = search(arr,10);
        System.out.println(result);

//        System.out.println(Arrays.toString(fib()));
    }

    private static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();
        while (high > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k-1]-1;
            if(key< temp[mid]){
                high = mid -1;
                k--;
            }else if(key> temp[mid]){
                low = mid+1;
                k-=2;
            }else {
                if(mid<=high){
                    return mid;

                }else {
                    return high;
                }

            }
        }
        return -1;
    }

    /*
    通过黄金分割，找到合适的 mid，将数组分成两部分。
     */
    private static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

}
