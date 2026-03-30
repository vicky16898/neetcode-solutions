package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        if (root != null)
            bfs.add(root);
        while (bfs.size() > 0) {
            int size = bfs.size();
            while (size > 0) {
                TreeNode tn = bfs.remove();
                if (tn.left != null)
                    bfs.add(tn.left);
                if (tn.right != null)
                    bfs.add(tn.right);
                size--;
                if (size == 0)
                    res.add(tn.val);
            }

        }
        return res;
    }
}
