package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), res, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return res;
    }

    private void backtrack(int n, int row, List<String> sol, List<List<String>> res, Set<Integer> col,
            Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row >= n) {
            res.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col.contains(i) || posDiag.contains(row + i) || negDiag.contains(row - i))
                continue;
            col.add(i);
            posDiag.add(row + i);
            negDiag.add(row - i);
            char[] rowArr = new char[n];
            Arrays.fill(rowArr, '.');
            rowArr[i] = 'Q';
            String rowStr = new String(rowArr);
            sol.add(rowStr);
            backtrack(n, row + 1, sol, res, col, posDiag, negDiag);
            col.remove(i);
            posDiag.remove(row + i);
            negDiag.remove(row - i);
            sol.remove(sol.size() - 1);

        }
    }
}
