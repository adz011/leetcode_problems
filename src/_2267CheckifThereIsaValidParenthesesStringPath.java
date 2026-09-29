public class _2267CheckifThereIsaValidParenthesesStringPath {

    private boolean[][][] seen;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') return false;
        if ((m + n) % 2 == 0) return false;
        seen = new boolean[m][n][m + n];
        return helper(grid, 0, 0, 0);
    }

    private boolean helper(char[][] grid, int y, int x, int open) {
        int m = grid.length, n = grid[0].length;
        open += grid[y][x] == '(' ? 1 : -1;
        if (open < 0) return false;
        if (y == m - 1 && x == n - 1) return open == 0;
        if (seen[y][x][open]) return false;
        seen[y][x][open] = true;

        return (y + 1 < m && helper(grid, y + 1, x, open))
                || (x + 1 < n && helper(grid, y, x + 1, open));
    }
}
