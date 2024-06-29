package LinkedList;

public class RemoveNthFromEnd_19 {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 使用快慢指针
     * @param head 头节点
     * @param n 删除的倒数第n个元素
     * @return 头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;

        // 快指针移动n+1个位置，这样在结束时慢指针可以指向需要删除元素的前一个元素
        for (int i=0; i<n; i++){
            if (fast.next != null) {
                fast = fast.next;
            }else{
                return head;
            }
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // 避免空指针异常
        if (slow.next != null){
            slow.next = slow.next.next;
        }

        return dummyHead.next;
    }
}
