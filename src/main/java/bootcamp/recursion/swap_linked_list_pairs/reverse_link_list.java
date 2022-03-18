package bootcamp.recursion;

import bootcamp.ListNode;

public class reverse_link_list {

    ListNode resultHead =null;
    public ListNode reverseList(ListNode head) {
        helper(head);
        return resultHead;
    }
    public ListNode helper(ListNode head) {
        if(head==null || head.next==null){
            resultHead = head;
            return head;
        }
        ListNode nextNode = helper(head.next);
        nextNode.next = head;
        return head;
    }
}
