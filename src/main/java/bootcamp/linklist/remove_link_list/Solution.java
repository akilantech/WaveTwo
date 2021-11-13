package bootcamp.linklist.remove_link_list;

import bootcamp.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new Solution().removeElements(ListNode.arrayToList(1, 1, 1, 3), 1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinal = new ListNode();
        sentinal.next = head;
        ListNode curr = head;
        ListNode prev = sentinal;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinal.next;
    }

}
