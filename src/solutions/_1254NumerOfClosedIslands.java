package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

public class _1254NumerOfClosedIslands {
    boolean[][] visited;
    int width, height;

    public int closedIsland(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        visited = new boolean[height][width];
        Deque<Coordinate> queue = new ArrayDeque<>();
        int count = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid[y][x] == 0 && !visited[y][x]) {
                    queue.add(new Coordinate(y, x));
                    visited[y][x] = true;
                    if (dfs(grid, queue)) count++;
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, Deque<Coordinate> queue) {
        boolean isTotalIsland = true;
        while (!queue.isEmpty()) {
            Coordinate cc = queue.pop();
            int cx = cc.x, cy = cc.y;
            if (cx == 0 || cx == width - 1 || cy == 0 || cy == height - 1) isTotalIsland = false;
            if (cx > 0 && grid[cy][cx - 1] == 0 && !visited[cy][cx - 1]) {
                visited[cy][cx - 1] = true;
                queue.add(new Coordinate(cy, cx - 1));
            }
            if (cy > 0 && grid[cy - 1][cx] == 0 && !visited[cy - 1][cx]) {
                visited[cy - 1][cx] = true;
                queue.add(new Coordinate(cy - 1, cx));
            }
            if (cx < width - 1 && grid[cy][cx + 1] == 0 && !visited[cy][cx + 1]) {
                visited[cy][cx + 1] = true;
                queue.add(new Coordinate(cy, cx + 1));
            }
            if (cy < height - 1 && grid[cy + 1][cx] == 0 && !visited[cy + 1][cx]) {
                visited[cy + 1][cx] = true;
                queue.add(new Coordinate(cy + 1, cx));
            }
        }
        return isTotalIsland;
    }

    record Coordinate(int y, int x) {
    }

}
