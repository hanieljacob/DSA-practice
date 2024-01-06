class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode headPtr = head;
        ListNode prev = null;
        ListNode next;
        while(headPtr!=null){
            next = headPtr.next;
            headPtr.next = prev;
            prev = headPtr;
            headPtr = next;
        }
        return prev;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)