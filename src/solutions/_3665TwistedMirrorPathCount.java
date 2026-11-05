package solutions;

public class _3665TwistedMirrorPathCount {
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int MOD = 1_000_000_007;
        dp[0][0] = 1;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) continue;
                for (int d = 0; d < 2; d++) {
                    int t = jump(grid, i, j, d);
                    if (t == -1) continue;
                    int r = t / n, c = t % n;
                    dp[r][c] = (dp[r][c] + dp[i][j]) % MOD;
                }
            }
        return dp[m-1][n-1];

    }
    int jump(int[][] g, int r, int c, int dir) {
        int m = g.length, n = g[0].length;
        if (dir == 0) c++; else r++;
        while (r < m && c < n && g[r][c] == 1) {
            if (dir == 0) { r++; dir = 1; }
            else          { c++; dir = 0; }
        }
        return (r < m && c < n) ? r * n + c : -1;
    }
}
