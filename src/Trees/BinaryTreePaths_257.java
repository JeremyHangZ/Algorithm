package Trees;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class BinaryTreePaths_257 {
    public List<String> binaryTreePaths(MyTreeNode root) {
        List<String> res = new ArrayList<>();

        if (root == null){
            return res;
        }
        
        ArrayList<Integer> paths = new ArrayList<>();
        traversal(root,paths,res);

        return res;
    }

    public void traversal(MyTreeNode root, ArrayList<Integer> paths, List<String> res){
        paths.add(root.val);

        if (root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.getLast());
            res.add(sb.toString());
            return;
        }

        if (root.left != null){
            traversal(root.left, paths, res);
            paths.removeLast();
        }

        if (root.right != null){
            traversal(root.right, paths, res);
            paths.removeLast();
        }
    }
}
