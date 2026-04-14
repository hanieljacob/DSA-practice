# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        temp = result
        carry, l1_val, l2_val = 0, 0, 0
        while l1 or l2:
            l1_val = l1.val if l1 else 0
            l2_val = l2.val if l2 else 0
            curr_sum = l1_val + l2_val + carry
            carry = curr_sum//10
            temp.next = ListNode(curr_sum%10)
            temp = temp.next
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
        if carry == 1:
            temp.next = ListNode(1)
            temp = temp.next
        return result.next