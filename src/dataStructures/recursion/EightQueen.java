package dataStructures.recursion;

//???????????????????????????????????
public class EightQueen {
    int max = 8;
    int[] arr = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.check(0);

    }


    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i; //第 n 个棋 放入第 n 行的 i 位置。
            if (judge(n)) {
                check(n + 1);
            }
            //else 继续 for。。。
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 行距 == 列距 即统一斜线
            if (arr[i] == arr[0] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            count++;
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }


}
