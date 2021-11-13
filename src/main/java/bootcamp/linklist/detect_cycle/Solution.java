package bootcamp.linklist.detect_cycle;

import bootcamp.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode  head = new ListNode(5);
        ListNode two = new ListNode(2, new ListNode(3,new ListNode(4,head)));
        //head.next = two;

        System.out.println(new Solution().hasCycle(two));
    }

    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                return true;
            }

        }
        return false;
    }
}
