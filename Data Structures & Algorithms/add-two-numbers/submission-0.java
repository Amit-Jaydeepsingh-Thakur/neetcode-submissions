/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i = 0, j = 0, sum = 0, carry = 0;
        ListNode head = new ListNode(-1);
        ListNode res = head;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);

            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);

            l1 = l1.next;
            head = head.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            head.next = new ListNode(sum);

            l2 = l2.next;
            head = head.next;
        }

        if (carry != 0) {
            head.next = new ListNode(carry);
        }

        return res.next;
    }
}
