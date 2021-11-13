package bootcamp.linklist.remove_nth_node_from_last;

public class RemoveNthNode1 {

    public static void main(String[] args) {
        LinkedList first = new LinkedList(1,
                new LinkedList(2,
                        new LinkedList(3,
                                new LinkedList(4,
                                        new LinkedList(5,
                                                new LinkedList(6, null))))));

        LinkedList pointer1 = first;
        LinkedList pointer2 = first.next;
        int n = 2;
        int count = 1;
        while (count < n -1 ) {
            count++;
            pointer1 = pointer2;
            pointer2 = pointer2.next;
        }
        pointer1.next = pointer2.next;

        while (first!=null){
            System.out.println(first.value);
            first = first.next;
        }

    }

    static public class LinkedList {
        int value;
        LinkedList next;

        public LinkedList(int value, LinkedList next) {
            this.value = value;
            this.next = next;
        }
    }
}
