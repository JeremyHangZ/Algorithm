package Trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView_199 {
    public List<Integer> rightSideView(MyTreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            size = queue.size();
            MyTreeNode cur;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }

                if (i == size - 1){
                    result.add(cur.val);
                }
            }
        }
        // 反转之后从底层到高层
        // Collections.reverse(result);
        return result;
    }
}
