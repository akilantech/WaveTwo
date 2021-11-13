package bootcamp.linklist.remove_link_list;

import bootcamp.ListNode;

public class Solution {

    /**
    *
    * Sentinel node is key
    * Sentinel node next will point to head.
    * prev and curr pointers will run thru the list.
    * when curr points the removal target, point prev.next to curr.next
    * sentinel.next points to root.
     * ote:refer examples
    *
    * */

    public static void main(String[] args) {
        ListNode listNode = new Solution().removeElements(ListNode.arrayToList(1, 2, 1, 3), 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    /**
     * Iteration 1
     * head -> 1 -> 1-> 1-> 3
     * sentinel.next -> 1 -> 1-> 1-> 3
     * prev = null -> 1 -> 1-> 1-> 3
     * curr -> 1 -> 1-> 1-> 3
     *
     *
     * Iteration 2
     *
     * head -> 1 -> 1-> 1-> 3
     * sentinel.next  -> 1-> 1-> 3
     * prev = (null)  -> 1-> 1-> 3
     *
     *
     */


    /**
     * Iteration 1
     * head -> 1 -> 2-> 1-> 3
     * sentinel.next -> 1 -> 2-> 1-> 3
     * prev = null -> 1 -> 2-> 1-> 3
     * curr -> 1 -> 2-> 1-> 3
     *
     *
     * Iteration 2
     *
     * head -> 1 -> 2-> 1-> 3
     * sentinel.next  -> 2-> 1-> 3
     * prev = (null)  -> 2-> 1-> 3
     * cur -> 2 -> 1-> 3
     *
     * Iteration 3
     * head -> 1 -> 2-> 1-> 3
     * sentinel.next  -> 2-> 1 -> 3
     * prev = (2) -> 1 -> 3
     * cur -> 1 -> 3
     *
     * Iteration 4
     * head -> 1 -> 2->  3
     * sentinel.next  -> 2 -> 3
     * prev = (2)  -> 3
     * cur = 3
     */



    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode curr = head;
        ListNode prev = sentinel;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

}
