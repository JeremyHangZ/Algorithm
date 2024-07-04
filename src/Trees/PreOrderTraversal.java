package Trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树结构前序遍历的两种方法， 迭代和递归
 */
public class PreOrderTraversal {
    /**
     * 递归：前序遍历
     * @param root （局部）根节点
     * @param res 输出列表
     */
    public void recursionPre(MyTreeNode root, List<Integer> res){

        if (root == null){
            return;
        }

        res.add(root.val);
        recursionPre(root.left,res);
        recursionPre(root.right,res);
    }

    /**
     * 迭代： 前序遍历
     * @param root 根节点
     * @return 输出列表
     */
    public List<Integer> iterativePre(MyTreeNode root){
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            res.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }
}
