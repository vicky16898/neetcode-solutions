package Tree;

public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int dia1 = 2 + height(root.left) + height(root.right);
        int dia2 = diameterOfBinaryTree(root.left);
        int dia3 = diameterOfBinaryTree(root.right);

        return Math.max(dia1, Math.max(dia2, dia3));
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
