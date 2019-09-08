package algorithm01.search.linearSearch;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1, -5, -9, -3, -8, 7, 0, 6, 11, -55, 4};
        int index = search(arr, 11);
        System.out.println(index);

    }
    private static int search(int[] arr, int value){
        for (int i=0;i<arr.length;i++){
             if(arr[i] ==value){
                 return i;
             }
        }
        return -1;
    }
}
