package solutions;

public class _0073SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        boolean[] cols = new boolean[width];
        boolean[] rows = new boolean[height];

        for (int c = 0; c < height; c++) {
            for (int r = 0; r < width; r++) {
                if (matrix[c][r] == 0) {
                    cols[r] = true;
                    rows[c] = true;
                }
            }
        }
        int r = 0;
        while (r < width) {
            if (cols[r]) {
                for (int c = 0; c < height; c++) {
                    matrix[c][r] = 0;
                }
            }
            r++;
        }

        int c = 0;
        while (c < height) {
            if (rows[c]) {
                for (int ri = 0; ri < width; ri++) {
                    matrix[c][ri] = 0;
                }
            }
            c++;
        }
    }

    public void setZerosInPlace(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstColumnContainsZero = false;

        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) firstColumnContainsZero = true;
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }

        if (firstColumnContainsZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }

    }

}
