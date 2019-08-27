package dataStructures.sparseMatrix;

/**
 * Created by Tommy on 2019/8/27.
 */
public class Matrix {

    public int[][] matrix = new int[11][11];
    int amountValues = 0;

    public Matrix() {
    }

    public Matrix(int x, int y) {
        int[][] matrix = new int[x][y];
    }



    public int[][] addValueForMatrix(int x, int y, int value) {

        this.matrix[x][y] = value;

        return matrix;
    }

    public void printMatrix(){
        for (int[] items : matrix) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    public int amountValuesOfMatrix(){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (matrix[i][j] != 0) {
                    this.amountValues++;
                }
            }
        }
        return this.amountValues;
    }


}
