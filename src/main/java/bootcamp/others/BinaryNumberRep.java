package bootcamp.others;

public class BinaryNumberRep {

    public static void main(String[] args) {

        LinkedList linkedList = arrayToList(1, 1, 1);

        //reverse
        //1->2->3
        //3->2->1

        LinkedList first = linkedList;
        LinkedList pointer = first.next;
        first.next = null;
        while (pointer != null) {
            LinkedList temp = pointer.next;
            pointer.next = first;
            first = pointer;
            pointer = temp;
        }
        linkedList = first;

        int decimal = 0;
        int count = 0;
        while (linkedList != null) {
            System.out.println(linkedList.value);
            if(linkedList.value == 1) {
                decimal += twoToThePower(count);
            }
            linkedList = linkedList.next;
            count++;
        }
        System.out.println("decimal"+decimal);

    }

    static int twoToThePower(int n) {
        if (n == 0) {
            return 1;
        } else {
            int base = 1;
            System.out.println("n" +n);
            for (int i = 0; i < n; i++) {
                base = base * 2;
            }
            return base;
        }
    }

    static LinkedList arrayToList(int... x) {
        LinkedList root = null;
        for (int i = 0; i < x.length; i++) {
            root = insert(root, x[i]);
        }
        return root;
    }

    private static LinkedList insert(LinkedList root, int x) {
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
