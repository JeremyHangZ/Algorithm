package LinkedList;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;

        if (head == null){
            return head;
        }

        while (cur.next != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        cur.next = pre;

        return cur;
    }
}
