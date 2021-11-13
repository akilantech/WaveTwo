package bootcamp;

public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

    static public ListNode arrayToList(int... x) {
        ListNode root = null;
        for (int i = 0; i < x.length; i++) {
            root = insert(root, x[i]);
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