package bootcamp.linklist.remove_nth_node_from_last;

import bootcamp.ListNode;

public class Solution {


    public static void main(String[] args) {
        ListNode listNode = ListNode.arrayToList(1, 2, 3);

        ListNode listNode1 = new Solution().removeNthFromEnd(listNode, 3);

        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode eliminator = head;
        int count = 0;
        while (first != null) {
            first = first.next;
            count++;
        }
        int target = (count + 1) - n;

        int x = 1;
        ListNode temp = null;
        while (x < target) {
            temp = eliminator;
            eliminator = eliminator.next;
            x++;
        }

        if (temp == null ) {
            head = head.next;
            return head;
        }

        temp.next = eliminator.next;
        return head;

    }
}
