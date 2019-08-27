package dataStructures.sparseMatrix;

/**
 * Created by Tommy on 2019/8/27.
 */
public class TestMain {
    public static void main(String[] args) {

        Matrix normalMatrix = new Matrix(11, 11);
        normalMatrix.addValueForMatrix(3, 4, 8);
        normalMatrix.addValueForMatrix(1, 2, 6);
        normalMatrix.addValueForMatrix(2, 3, 5);

        System.out.println("normalMatrix");
        normalMatrix.printMatrix();
        System.out.println("amount Values Of Matrix:");
        System.out.println(normalMatrix.amountValuesOfMatrix());

        SparseMatrix sparse = new SparseMatrix(11,11,3);
        sparse.addValueForMatrix(new int[] {1,2,1});
        sparse.addValueForMatrix(new int[] {2,3,6});
        sparse.addValueForMatrix(new int[] {6,4,9});

        sparse.printMatrix();
        System.out.println("amount Values Of Sparse:");
        System.out.println(sparse.amountValuesOfMatrix());
        System.out.println("===============================");


        int[][] matrix = new int[11][11];
        matrix[1][2] = 1;
        matrix[2][3] = 2;
        matrix[6][4] = 9;

        System.out.println("Matrix");
        for (int[] items : matrix) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (matrix[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println(sum);


        int[][] sparseMatrix = new int[sum + 1][3];
        sparseMatrix[0][0] = matrix.length;
        sparseMatrix[0][1] = matrix[1].length;
        sparseMatrix[0][2] = sum;

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (matrix[i][j] != 0) {
                    count++; // count = 0 时 记录的是矩阵规模; count= 1是记录数据坐标。
                    sparseMatrix[count][0] = i;
                    sparseMatrix[count][1] = j;
                    sparseMatrix[count][2] = matrix[i][j];
                }
            }
        }
        System.out.println("Sparse Matrix");
        for (int[] items : sparseMatrix) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }

        int x = 0;
        int y = 0;
        int value = 0;
        int[][] backToMatrix = new int[sparseMatrix[0][0]][sparseMatrix[0][1]];
        for (int i = 1; i < sparseMatrix[0][2]; i++) {
            x = sparseMatrix[i][0];
            y = sparseMatrix[i][1];
            value = sparseMatrix[i][2];
            backToMatrix[x][y] = value;
        }

        System.out.println("backToMatrix");
        for (int[] items : matrix) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }


    }
}
