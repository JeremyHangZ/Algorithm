package Trees;

import javax.swing.tree.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalanced_110 {
    public boolean isBalanced(MyTreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(MyTreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1){
            return -1;
        }

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1){
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        return Math.max(leftHeight, rightHeight);
    }
}
