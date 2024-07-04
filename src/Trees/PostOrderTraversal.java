package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    /**
     * 递归：后序遍历
     */
    public void recursionPost(MyTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        recursionPost(root.left, res);
        recursionPost(root.left, res);
        res.add(root.val);
    }

    /**
     * 迭代：后序遍历
     * 先序遍历是中左右，后序遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序
     * 然后在反转result数组，输出的结果顺序就是左右中了
     */
    public List<Integer> iterativePost(MyTreeNode root){
        ArrayList<Integer> nums = new ArrayList<>();

        if (root == null){
            return nums;
        }

        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            nums.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(nums);
        return nums;
    }
}
