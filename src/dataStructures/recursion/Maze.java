package dataStructures.recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;


        for (int[] row : map) {
            for (int item : row) {
                System.out.printf("%d  ", item);
            }
            System.out.println();
        }

        System.out.println("====================");
        setWay(map,1,1);

        for (int[] row : map) {
            for (int item : row) {
                System.out.printf("%d  ", item);
            }
            System.out.println();
        }

    }

    protected static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return  true;
        }else {
            if(map[i][j] ==0){
                map[i][j]=2;
                if(setWay(map, i+1 , j)){
                    return true;
                }else if(setWay(map, i, j+1)){
                    return true;
                }else if(setWay(map, i-1, j)){
                    return true;
                }else if(setWay(map, i, j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                return false; // 1,2,3
            }
        }
    }
}
