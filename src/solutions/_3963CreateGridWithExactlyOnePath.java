package solutions;

public class _3963CreateGridWithExactlyOnePath {
    public String[] createGrid(int m, int n) {
        String[] finalGrid = new String[m];
        finalGrid[0] = ".".repeat(n);

        for (int i = 1; i < m; i++) {
            String row = "#".repeat(n - 1) + '.';
            finalGrid[i] = row;
        }
        return finalGrid;
    }
}
