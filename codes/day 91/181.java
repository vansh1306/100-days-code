/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> lt = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.remove();
                lt.add(curr.val);

                List<Node> temp = curr.children;
                for (int j = 0; j < temp.size(); j++) {
                    q.add(temp.get(j));
                }
            }

            ans.add(lt);
        }
        return ans;
    }
}