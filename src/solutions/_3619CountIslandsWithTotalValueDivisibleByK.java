package solutions;

public class _3619CountIslandsWithTotalValueDivisibleByK {
    static boolean[][] visited;

    static public int countIslands(int[][] grid, int k) {
        int width = grid[0].length;
        int height = grid.length;
        visited = new boolean[height][width];
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!visited[y][x] && grid[y][x] > 0) {
                    if (dfs(grid, x, y) % k == 0) count++;
                }
            }
        }
        return count;
    }

    static private long dfs(int[][] grid, int x, int y) {
        if (visited[y][x] || grid[y][x] == 0) return 0;
        visited[y][x] = true;
        long sum = grid[y][x];
        if (x > 0) {
            sum += dfs(grid, x - 1, y);
        }
        if (x < grid[0].length - 1) {
            sum += dfs(grid, x + 1, y);
        }
        if (y > 0) {
            sum += dfs(grid, x, y - 1);
        }
        if (y < grid.length - 1) {
            sum += dfs(grid, x, y + 1);
        }
        return sum;
    }

}
