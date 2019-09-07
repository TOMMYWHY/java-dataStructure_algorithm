package algorithm01.sort.quick;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, -5, -9, -3, -8, 7, 0, 6, 11, -55, 4};
//        quick(arr, 0, arr.length - 1);
//        quick1(arr, 0, arr.length - 1);
//        quick2(arr, 0, arr.length - 1);
        quick3(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));

    }



    //======================
    private static void quick(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            } else if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quick(arr, left, r);
        }
        if (l < right) {
            quick(arr, l, right);
        }


    }

    private static void quick1(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
//        int pivot = arr[(left + right) / 2];//
        int pivot = arr[0];
        System.out.println(pivot);
        while (l < r) {
            while (arr[l] < pivot) {
                l++; //  l 游标没找到大于 pivot，便++移动到下一个；
            }
            while (arr[r] > pivot) {
                r--;
            }
            //跳出上面左右两个循环，则两方各找到一个需要交换的值
            if (l >= r) {
                break; //
            }
            if (l <= r) {
                temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;

            }
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
            if (l == r) {
                l++;
                r--;
            }
            if (left < r) {
                quick1(arr, left, r);
            }
            if (right > l) {
                quick1(arr, l, right);
            }

        }
    }

    private static void quick2(int[] a, int left, int right) {
        if (left > right)
            return;
        int pivot = a[left];//定义基准值为数组第一个数
        int i = left;
        int j = right;

        while (i < j) {
            while (pivot <= a[j] && i < j)//从右往左找比基准值小的数
                j--;
            while (pivot >= a[i] && i < j)//从左往右找比基准值大的数
                i++;
            if (i < j)                     //如果i<j，交换它们
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[left] = a[i];
        a[i] = pivot;//把基准值放到合适的位置
        quick2(a, left, i - 1);//对左边的子数组进行快速排序
        quick2(a, i + 1, right);//对右边的子数组进行快速排序
    }

    //======================


    private static void quick3(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            quick3(arr, low, pivot - 1);                   //递归排序左子数组
            quick3(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot){
                high--;
            }
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot){
                low++;
            }
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }



}
