package LinkedList;

public class MyLinkedList_707 {
    int size;
    ListNode head;

    public MyLinkedList_707() {
        // 链表长度
        size = 0;

        // 设置虚拟头节点
        head = new ListNode(0);
    }

    /**
     * 找对应下表的值
     * @return value at that index
     */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }

        ListNode curr = head;

        // 虚拟头节点为index 0 ，还需要再往后找index + 1 个位置
        for (int i=0; i<=index; i++){
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }


    // 加入元素
    // 找到要加入的下标位置的元素和前一个元素，然后在两者之间加入。

    /**
     * 加入元素
     * 找到要加入的下标位置的元素和前一个元素，然后在两者之间加入。
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size){
            return;
        }

        ListNode cur = head;
        ListNode post;

        if (index == size) { // 末尾加入
            for (int i=0;i<index;i++){
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        } else if (index == 0) { // 头部加入
            post = head.next;
            head.next = new ListNode(val);
            head.next.next = post;
        } else { // 其他位置加入
            for (int j=0;j<=index - 1 ;j++){
                cur = cur.next;
            }
            post = cur.next;
            cur.next = new ListNode(val);
            cur.next.next = post;
        }

        size ++;
    }


    /**
     * 删除元素
     * 找到删除元素前一个元素和后一个元素，把两者链接起来
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size){
            return;
        }
        ListNode pre = head;
        ListNode post;

        for (int i=0;i<index;i++){
            pre = pre.next;
        }

        post = pre.next.next;

        pre.next = post;

        size--;
    }


}