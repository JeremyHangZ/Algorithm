package Trees;

import javax.swing.tree.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree_226 {
    // DFS
    public MyTreeNode invertTree(MyTreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }

    public void swapChildren(MyTreeNode root){
        MyTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
