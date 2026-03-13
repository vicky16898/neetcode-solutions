package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IslandAndTreasure {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Node> bfs = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    bfs.add(new Node(i, j));
            }
        }

        while (bfs.size() > 0) {
            Node node = bfs.remove();

            int row = node.row;
            int col = node.col;

            if (col + 1 < grid[0].length && grid[row][col + 1] == Integer.MAX_VALUE) {
                grid[row][col + 1] = 1 + grid[row][col];
                bfs.add(new Node(row, col + 1));
            }
            if (col - 1 >= 0 && grid[row][col - 1] == Integer.MAX_VALUE) {
                grid[row][col - 1] = 1 + grid[row][col];
                bfs.add(new Node(row, col - 1));
            }
            if (row + 1 < grid.length && grid[row + 1][col] == Integer.MAX_VALUE) {
                grid[row + 1][col] = 1 + grid[row][col];
                bfs.add(new Node(row + 1, col));
            }
            if (row - 1 >= 0 && grid[row - 1][col] == Integer.MAX_VALUE) {
                grid[row - 1][col] = 1 + grid[row][col];
                bfs.add(new Node(row - 1, col));
            }
        }
    }
}

class Node {
    int row;
    int col;

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
