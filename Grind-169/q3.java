// Definition for singly-linked list. 
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        while(list1!=null && list2!=null){
            if(list1.val > list2.val){
                ptr.next = list2;
                list2 = list2.next;
            }
            else{
                ptr.next = list1;
                list1 = list1.next;
            }
            ptr = ptr.next;
        }
        if(list1 == null)
            ptr.next = list2;
        else
            ptr.next = list1;
        return head.next;
    }
}

// Time Complexity: O(n+m)
// Space Complexity: O(1)