/*
.next
.val

1 3 5
2 4 6

set dummy node to first math val
compare both lists val
attach higher one to ret (dummy) list

*/

public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode temp = new ListNode(0);
    ListNode current = temp;
    
    while (list1 != null && list2 != null) {
        if (list1.val > list2.val) {
            current.next = list1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next;
    }
    if (list1 == null) {
        current.next = list2;
    } else if (list2 == null) {
        current.next = list1;
    }
    return temp.next;
}

// time: O(n + m)
// space: O(1)