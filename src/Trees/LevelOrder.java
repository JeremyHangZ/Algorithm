package Trees;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(MyTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<MyTreeNode> queue = new LinkedList<>();
        int size = 0;
        queue.add(root);

        while (!queue.isEmpty()){
            size = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            MyTreeNode cur;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null){
                    queue.add(cur.left);
                }
                if (cur.right != null){
                    queue.add(cur.right);
                }

                integers.add(cur.val);
            }
            result.add(integers);
        }
        return result;
    }
}
