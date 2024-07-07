package Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Connect_116 {

    public Node connect(Node root) {
        Queue<Node> tmpQueue = new LinkedList<Node>();
        if (root != null) tmpQueue.add(root);

        while (!tmpQueue.isEmpty()){
            int size = tmpQueue.size();

            Node cur = tmpQueue.poll();
            if (cur.left != null) tmpQueue.add(cur.left);
            if (cur.right != null) tmpQueue.add(cur.right);

            for (int index = 1; index < size; index++){
                Node next = tmpQueue.poll();
                if (next.left != null) tmpQueue.add(next.left);
                if (next.right != null) tmpQueue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }

        return root;
    }

    public Node connect_MyVersion(Node root) {
        if (root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            Node cur;
            for (int i = 0; i < size; i++) {
                if (i == 0){
                    pre = queue.poll();
                    if (pre.left != null){
                        queue.add(pre.left);
                    }
                    if (pre.right != null){
                        queue.add(pre.right);
                    }
                }else{
                    cur = queue.poll();
                    if (cur.left != null){
                        queue.add(cur.left);
                    }
                    if (cur.right != null){
                        queue.add(cur.right);
                    }
                    pre.next = cur;
                    pre = cur;
                }
            }
            pre.next = null;
        }

        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}