package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j, grid));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i, int j, int[][] grid) {
        Queue<Pos> bfs = new LinkedList<>();
        int area = 1;
        grid[i][j] = -1;
        bfs.add(new Pos(i, j));
        while (!bfs.isEmpty()) {
            Pos node = bfs.remove();
            int x = node.x;
            int y = node.y;

            if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                bfs.offer(new Pos(x + 1, y));
                area++;
                grid[x + 1][y] = -1;
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                bfs.offer(new Pos(x, y + 1));
                area++;
                grid[x][y + 1] = -1;
            }
            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                bfs.offer(new Pos(x - 1, y));
                area++;
                grid[x - 1][y] = -1;
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                bfs.offer(new Pos(x, y - 1));
                area++;
                grid[x][y - 1] = -1;
            }
        }
        return area;
    }
}

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
