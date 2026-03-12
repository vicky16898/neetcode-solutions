package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    bfs(i, j, grid);
                }
            }
        }
        return num;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<Pos> bfs = new LinkedList<>();
        grid[i][j] = 'X';
        bfs.add(new Pos(i, j));
        while (!bfs.isEmpty()) {
            Pos node = bfs.remove();
            int x = node.x;
            int y = node.y;

            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                bfs.offer(new Pos(x + 1, y));
                grid[x + 1][y] = 'X';
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                bfs.offer(new Pos(x, y + 1));
                grid[x][y + 1] = 'X';
            }
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                bfs.offer(new Pos(x - 1, y));
                grid[x - 1][y] = 'X';
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                bfs.offer(new Pos(x, y - 1));
                grid[x][y - 1] = 'X';
            }
        }
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
