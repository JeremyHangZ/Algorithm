package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树结构中序遍历，递归+迭代
 */
public class InOrderTraversal {

    /**
     * 递归：中序遍历
     */
    public void recursionIn(MyTreeNode root, List<Integer> res){
        if (root == null) {
            return;
        }

        recursionIn(root.left, res);
        res.add(root.val);
        recursionIn(root.right,res);
    }

    /**
     * 迭代：中序遍历
     * 中序遍历是左中右，先访问的是二叉树顶部的节点，然后一层一层向下访问，直到到达树左面的最底部，再开始处理节点
     */
    public List<Integer> iterativeIn(MyTreeNode root){
        ArrayList<Integer> nums = new ArrayList<>();

        if (root == null){
            return nums;
        }

        Stack<MyTreeNode> stack = new Stack<>();

        MyTreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                nums.add(cur.val);
                cur = cur.right;
            }
        }

        return nums;
    }
}
