package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        if (root != null)
            bfs.add(root);
        while (bfs.size() > 0) {
            int size = bfs.size();
            List<Integer> level = new ArrayList<>();
            while (size > 0) {
                TreeNode tn = bfs.remove();
                level.add(tn.val);
                if (tn.left != null)
                    bfs.add(tn.left);
                if (tn.right != null)
                    bfs.add(tn.right);
                size--;
            }
            res.add(new ArrayList<>(level));
        }
        return res;

    }
}
