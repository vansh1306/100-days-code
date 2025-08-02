public class Solution {
    public boolean hasCycle(ListNode head) {
    
        ListNode tortoise = head; 
        ListNode rabbit = head;  
        while (rabbit != null && rabbit.next != null) {
            // Tortoise moves one step
            tortoise = tortoise.next;  
            // Rabbit moves two steps
            rabbit = rabbit.next.next;
            // Check if they meet at the same spot
            if (tortoise == rabbit) {
                         return true;
            }
        }
        
        return false;
    }
}