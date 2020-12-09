# Solved (Hard)


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """

        if k == 1:
            return head

        sizeOfList = 0
        sizeTemp = head
        while sizeTemp is not None:
            sizeOfList += 1
            sizeTemp = sizeTemp.next

        if k == 2:
            t1 = head
            t2 = head.next

            head = head.next

            for x in range(sizeOfList//k):
                if x != 0:
                    t2 = t1.next
                    t1.next = t2.next
                    t1 = t2
                    t2 = t2.next

                t1.next = t2.next
                t2.next = t1

            return head

        else:

            tHead = head
            t1 = tHead
            t2 = t1.next
            t3 = t2.next

            for x in range(k - 1):
                head = head.next

            for x in range(k - 1):
                tHead.next = tHead.next.next

            #Main loop: repeats as many times as list size is divisible by k.
            for x in range((sizeOfList//k)):

                if x != 0:
                    for x in range(k - 1):
                        tHead.next = tHead.next.next

                    tHead = t2
                    t1 = tHead
                    t2 = t1.next
                    t3 = t2.next

                    for x in range(k - 1):
                        tHead.next = tHead.next.next


                for x in range(k-1):
                    t2.next = t1
                    t1 = t2
                    t2 = t3
                    if t3 is not None:
                        t3 = t3.next

            return head


