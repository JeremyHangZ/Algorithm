package LinkedList;

public class SwapPairs_24 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @param head 链表头节点
     * @return 新的列表头节点
     */
    public ListNode swapPairs(ListNode head){
        // 虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode firstNode;
        ListNode secondNode;
        ListNode thirdNode;

        while (cur.next != null && cur.next.next != null){
            thirdNode = cur.next.next.next;
            firstNode = cur.next;
            secondNode = cur.next.next;
            cur.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = thirdNode;
            cur = firstNode;
        }

        return dummyHead.next;
    }
}
