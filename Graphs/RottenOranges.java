package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<Orange> bfs = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    bfs.add(new Orange(i, j));
                else if (grid[i][j] == 1)
                    fresh++;
            }
        }
        if (fresh == 0)
            return 0;
        int time = Integer.MIN_VALUE;
        while (bfs.size() > 0) {
            Orange o = bfs.remove();
            int r = o.row;
            int c = o.col;

            if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
                grid[r][c + 1] = -1;
                fresh--;
                Orange rt = new Orange(r, c + 1);
                rt.time = o.time + 1;
                time = Math.max(rt.time, time);
                bfs.add(rt);
            }
            if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                grid[r + 1][c] = -1;
                fresh--;
                Orange rt = new Orange(r + 1, c);
                rt.time = o.time + 1;
                time = Math.max(rt.time, time);
                bfs.add(rt);
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                grid[r][c - 1] = -1;
                fresh--;
                Orange rt = new Orange(r, c - 1);
                rt.time = o.time + 1;
                time = Math.max(rt.time, time);
                bfs.add(rt);
            }
            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                grid[r - 1][c] = -1;
                fresh--;
                Orange rt = new Orange(r - 1, c);
                rt.time = o.time + 1;
                time = Math.max(rt.time, time);
                bfs.add(rt);
            }
        }

        return fresh == 0 ? time : -1;
    }
}

class Orange {
    int row;
    int col;
    int time;

    public Orange(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
