package algorithm01.search.binary;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 7, 10, 81, 577, 743, 2030, 2599, 3138, 3221, 4127, 4793, 5622, 9420, 9680};
        int resultIndex = search(arr,0,arr.length-1,17);
        System.out.println(resultIndex);
    }

    private static int search(int[] arr, int left, int right, int findValue) {
        if(left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midValue = arr[mid];
        if (findValue < midValue) {
            return search(arr, left, mid - 1, findValue);
        } else if (findValue > midValue) {
            return search(arr, mid + 1, right, findValue);
        }else {
            return mid;
        }
    }
}
