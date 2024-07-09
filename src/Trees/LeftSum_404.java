package Trees;

public class LeftSum_404 {
    /**
     * 给定二叉树的根节点 root ，返回所有左叶子之和。
     */
    public int sumOfLeftLeaves(MyTreeNode root) {
        if (root == null){
            return 0;
        }

        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);

        int midVal = 0;
        if (root.left != null && root.left.left == null && root.left.right == null){
            midVal = root.left.val;
        }

        return midVal + leftVal + rightVal;
    }


}
