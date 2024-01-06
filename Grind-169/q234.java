class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode headPtr = head;
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        while(prev!=null){
            if(prev.val != headPtr.val)
                return false;
            prev = prev.next;
            headPtr = headPtr.next;
        }
        return true;   
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)