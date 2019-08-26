package s01.arrays;

/**
 * Created by Tommy on 2019/8/26.
 */
public class PrimeNumber {


    public static void main(String[] args) {

        final int total = 100;
        int[] arr = new int[50];
        int index = 0;
        for (int i = 2; i < 100; i++) {
            boolean isPrime = false;
            for (int j = 2; j <= (i - 1); j++) {
                if (i % j == 0) {
                    isPrime = true;
                    break;
                }
            }
            if (isPrime == false) {
                arr[index] = i;
                index++;
            }
        }
        int[] primeNum = new int[index];
        for(int i = 0; i<primeNum.length;i ++){
            primeNum[i] = arr[i];
        }
        for (int item : primeNum) {
            System.out.print(item + ",");
        }

    }
}
