package bootcamp.linklist.reorder_list;

import bootcamp.ListNode;

public class Solution
{

    public static void main(String[] args) {
        ListNode listNode = ListNode.arrayToList(1, 2,3);

        new Solution().reorderList(listNode);
    }
    public void reorderList(ListNode head) {

        //Find the middle node

        ListNode curr = head;
        int count = 1;
        while (curr!=null){
            count++;
            curr = curr.next;
        }
        System.out.println("count:"+count);
        if(count-1<3){
            System.out.println();
            return;
        }
        int middle = (count +1)/2;


        curr = head;
        count = 1;
        ListNode temp=null;
        while (count < middle ){
            temp = curr;
            curr =curr.next;
            count++;
        }
            temp.next = null;
        ListNode h = curr;
        curr = curr.next;
        h.next=null;
        while (curr.next!=null){
            ListNode next = curr.next;
            curr.next=h;
            h = curr;
            curr = next;
        }
        curr.next =h;
        ListNode m1 = head;
        ListNode prev = null;
        while (m1!=null && curr!=null){
            ListNode next = m1.next;
            ListNode currNext = curr.next;
            m1.next = curr;
            m1 = m1.next;
            m1.next=next;
            prev = m1;
            m1 = m1.next;
            curr = currNext;
        }

        if(m1==null){
            prev.next=curr;
        }

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
