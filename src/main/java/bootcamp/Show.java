package bootcamp;

public class Show {

    public static void main(String[] args) {
        LinkedList first = arrayToList(1,2,3);

        LinkedList pointer = first;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.next;
        }
    }

    static LinkedList arrayToList(int... x) {
        LinkedList root = null;
        for (int i = 0; i < x.length; i++) {
            root = insert(root, x[i]);
        }
        return root;
    }

    private static  LinkedList insert(LinkedList root, int x) {
        LinkedList temp = new LinkedList(x, null);
        if (root == null) {
            root = temp;
        } else {
            LinkedList ptr = root;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = temp;
        }
        return root;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }

    }
}
