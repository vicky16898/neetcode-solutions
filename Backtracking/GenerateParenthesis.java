package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(n, 0, 0, result, new StringBuilder());
        return result;
    }

    private void recurse(int n, int open, int closed, List<String> res, StringBuilder sb) {
        if (open == n && open == closed) {
            res.add(sb.toString());
            return;
        }

        if (closed < open) {
            sb.append(")");
            recurse(n, open, closed + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open < n) {
            sb.append("(");
            recurse(n, open + 1, closed, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
