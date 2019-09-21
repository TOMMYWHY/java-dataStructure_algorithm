package algorithm02.non_recursion_binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 7, 7, 10, 81, 577, 743, 2030, 2599, 3138, 3221, 4127, 4793, 5622, 9420, 9680};
        int result =  search(arr,7);
        System.out.println(result);
    }

    private static int search(int[] arr, int target) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if(arr[mid] ==target ){
                return mid;
            }else if(arr[mid]>target){
                rightIndex = mid -1; //向左侧查找
            }else {
                leftIndex = mid +1; //向右查找
            }

        }
        return -1;
    }
}
