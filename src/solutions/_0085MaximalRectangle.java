package solutions;

public class _0085MaximalRectangle {
    static public int maximalRectangle(char[][] matrix) {
        int yMax = matrix.length;
        int xMax = matrix[0].length;
        int[][] dpX = new int[yMax][xMax];
        int[][] dpY = new int[yMax][xMax];
        for (int i = 0; i < yMax; i++) {
            for (int j = 0; j < xMax; j++) {
                if(matrix[i][j] == '1'){
                    int x = 1;
                    int y = 1;
                    if(i > 0) y+= dpY[i-1][j];
                    if(j > 0) x+=dpX[i][j-1];
                    dpY[i][j] = y;
                    dpX[i][j] = x;
                }else{
                    dpY[i][j] = 0;
                    dpX[i][j] = 0;
                }
            }
        }
        return 0;
    }

}
