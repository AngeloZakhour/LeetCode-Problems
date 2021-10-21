package com.company;//SUCCESSFUL
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode((l1.val+l2.val)%10);
        int carry=(l1.val + l2.val)/10;
        ListNode temp = result;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null){
            temp.next = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            temp = temp.next;
        }
        while(l1 != null){
            temp.next = new ListNode((l1.val+carry)%10);
            carry = (l1.val+carry)/10;
            l1 = l1.next;
            temp = temp.next;
        }
        while(l2 != null){
            temp.next = new ListNode((l2.val+carry)%10);
            carry = (l2.val+carry)/10;
            l2 = l2.next;
            temp = temp.next;
        }
        if(l1 == null && l2 == null && carry != 0){
            temp.next = new ListNode(carry);
        }

        return result;
    }
}