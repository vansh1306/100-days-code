/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        

        Node mover = head;
        while(mover != null){
            Node node = new Node(mover.val);
            Node next = mover.next;

            mover.next = node;
            node.next = next;
            node.random = mover.random;

            mover = mover.next.next;
        }

        mover = head;
        while(mover !=null){
            mover.next.random = (mover.random == null)? null: mover.random.next;

            mover = mover.next.next;
        }

        mover = head;
        head = head.next;
        while(mover != null){
            Node next = mover.next.next;
            
            mover.next.next = (next != null)? next.next: null;
            mover.next = next;

            mover = mover.next;
        }

        // mover = head;
        // while(mover != null){
        //     System.out.print(mover.val +" ");
        //     mover = mover.next;
        // }

        return head;
    }
}