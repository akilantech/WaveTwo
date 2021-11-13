package bootcamp.linklist.reverse_list;

import bootcamp.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode curr = ListNode.arrayToList(1, 2, 3, 4);

        ListNode listNode = new Solution().reverseList(curr);

        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
      }

}
