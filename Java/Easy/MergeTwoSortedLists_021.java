
import java.util.ArrayList;
import java.util.List;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MergeTwoSortedLists_021 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        ListNode l1 = createListNode(list1);
        ListNode l2 = createListNode(list2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(); 
    ListNode current = dummy; //place in the new sorted list

    while (list1 != null && list2 != null) {
        if (list1.val <= list2.val) {
            current.next = new ListNode(list1.val);
            list1 = list1.next; //next node in the list1 
        } else {
            current.next = new ListNode(list2.val);
            list2 = list2.next;
        }
        current = current.next;
    }
    //needed to add the remaining elements if the the the other list ends faster
    while (list1 != null) {
        current.next = new ListNode(list1.val);
        list1 = list1.next;
        current = current.next;
    }

    while (list2 != null) {
        current.next = new ListNode(list2.val);
        list2 = list2.next;
        current = current.next;
    }

    return dummy.next; //return the list without the first dummy node
}

    public static ListNode createListNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;
        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return head;
    }

}
