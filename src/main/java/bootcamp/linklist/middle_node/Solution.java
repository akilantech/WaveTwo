package bootcamp.linklist.middle_node;

import bootcamp.ListNode;

public class Solution {

    public static void main(String[] args) {
        ListNode listNode = ListNode.arrayToList(1, 2, 3,4,5);

        System.out.println(new Solution().middleNode(listNode).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        int count = 1;
        while (first.next != null) {
            count++;
            first = first.next;
        }

        int middle = (count / 2) + 1;
        int targetMiddle = 1;
        while (targetMiddle < middle) {
            targetMiddle++;
            second = second.next;
        }
        return second;
    }
}
