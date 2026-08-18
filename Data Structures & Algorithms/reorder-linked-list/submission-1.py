# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:

        slow, fast = head, head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        curr = slow.next
        slow.next = None

        prev = None 
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        while prev:
            next = head.next
            head.next = prev
            prev_next = prev.next
            prev.next = next
            prev = prev_next
            head = next


