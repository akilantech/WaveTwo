package bootcamp.linklist.merge_two_list;

import bootcamp.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                root = insert(root, l1.val);
                l1 = l1.next;
            } else {
                root = insert(root, l2.val);
                l2 = l2.next;
            }
        }

        if (l1 == null & l2 != null) {
            while (l2 != null) {
                root = insert(root, l2.val);
                l2 = l2.next;
            }
        }

        if (l2 == null & l1 != null) {
            while (l1 != null) {
                root = insert(root, l1.val);
                l1 = l1.next;
            }
        }

        return root;
    }

    private static ListNode insert(ListNode root, int x) {
        ListNode temp = new ListNode(x, null);
        if (root == null) {
            root = temp;
        } else {
            ListNode ptr = root;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return root;
    }

}
