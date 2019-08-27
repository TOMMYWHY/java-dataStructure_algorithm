package dataStructures.sparseMatrix;

/**
 * Created by Tommy on 2019/8/27.
 */
public class SparseMatrix {
    public int[][] matrix = new int[1][3];
    int amountValues = 0;
    int addTimes = 0;

    public SparseMatrix() {
    }

    public SparseMatrix(int x, int y,int amountValues) {
        this.amountValues = amountValues;
        this.matrix = new int[this.amountValues+1][3];
        this.matrix[0][0] = x;
        this.matrix[0][1] = y;
        this.matrix[0][2] = this.amountValues;//3
    }



    public void addValueForMatrix(int[] indexValue) {
        addTimes++;
        matrix[addTimes][0]  = indexValue[0];
        matrix[addTimes][1]  = indexValue[1];
        matrix[addTimes][2]  = indexValue[2];
    }

    public void printMatrix(){
        for (int[] items : this.matrix) {
            for (int item : items) {
                System.out.printf("%d\t", item);
            }
            System.out.println();
        }
    }

    public int amountValuesOfMatrix(){


        return this.matrix[0][2];
    }

}
