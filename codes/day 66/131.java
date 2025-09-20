/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int postidx;
    public HashMap<Integer, Integer> inordermap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postidx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inordermap.put(inorder[i], i);
        }

        return arrtotree(postorder, 0, inorder.length - 1);
    }

    public TreeNode arrtotree(int[] postorder, int left, int right) {
        if (left > right)
            return null;

        int rootvalue = postorder[postidx];
        TreeNode root = new TreeNode(rootvalue);
        postidx--;

        int inorderidx = inordermap.get(rootvalue);

        root.right = arrtotree(postorder, inorderidx + 1, right);
        root.left = arrtotree(postorder, left, inorderidx - 1);
        return root;
    }
}