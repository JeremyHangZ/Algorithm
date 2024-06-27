package LinkedList;

public class RemoveLinkedElem_203 {

    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */
    public ListNode removeElements(int val, ListNode head){
        // 检查头节点是否为目标值
        while (head != null && head.val == val){
            head = head.next;
        }

        // 如果删除头部元素后列表为空，提前退出
        if (head == null){
            return head;
        }

        // 确认了头节点不为空后，进入循环检查整个列表
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next; // 这一步删除元素
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list
 */
class ListNode {
    int val; // value stored
    ListNode next; // pointer to next listNode

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

