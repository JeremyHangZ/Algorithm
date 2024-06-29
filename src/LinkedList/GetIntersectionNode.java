package LinkedList;

public class GetIntersectionNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * 求出两个链表长度的差值，然后让curA移动到，和curB 末尾对齐的位置。
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交的那个节点 / null
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA, lenB;

        if (headA != null && headB != null){
            lenA = 1;
            lenB = 1;
        } else {
            return null;
        }

        // 测量A的长度
        while (curA.next != null){
            curA = curA.next;
            lenA++;
        }

        // 测量B长度
        while (curB.next != null){
            curB = curB.next;
            lenB++;
        }

        curA = headA;
        curB = headB;

        // 移动curA 与 curB 对齐
        if (lenA >= lenB){
            for (int i=0; i<(lenA - lenB); i++){
                curA = curA.next;
            }
        }else { // 移动curB 与 curA 对齐
            for (int i=0; i<(lenB - lenA); i++){
                curB = curB.next;
            }
        }

        // 一一对比直到找到相同节点或者返回null
        while (curA != null && curB != null){
            if (curA == curB){
                return curA;
            }else {
                curA = curA.next;
                curB = curB.next;
            }
        }

        return null;
    }
}
