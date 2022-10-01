package leetcodeSep2022;

/**
 *
 * @Sir Darey
 * 
 * LeetCode Daily Challenge: September 2022, Day 28
 * Problem 19: Remove Nth Node From End of List
 */

class Day28_19_RemoveNthNodeFromEnd {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        
        int removeIndex = length(head) - n;
        ListNode current = head;
        
        for (int i=0; i<removeIndex-1; i++)
            current = current.next;
        
        if (removeIndex == 0)
            return head.next;
        else
            current.next = current.next.next;
        return head;
    }
    
    int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
    
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

