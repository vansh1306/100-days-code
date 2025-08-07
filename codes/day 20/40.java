public class Solution {
  
    /**
     * Finds the middle node of a singly linked list.
     * 
     * @param head The head of the linked list.
     * @return The middle node of the linked list.
     */
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers, slow and fast.
        ListNode slowPointer = head;
        ListNode fastPointer = head;
      
        // Iterate through the list.
        // Fast pointer moves two steps at a time, slow pointer one step at a time.
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;       // Move slow pointer one step
            fastPointer = fastPointer.next.next;  // Move fast pointer two steps
        }
      
        // When fast pointer reaches the end of the list,
        // slow pointer will be at the middle element.
        return slowPointer;
    }
}
