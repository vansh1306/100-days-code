import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultPaths = new ArrayList<>();
        if (root == null) {
            return resultPaths;
        }
        StringBuilder pathBuilder = new StringBuilder();
        findPaths(root, pathBuilder, resultPaths);
        return resultPaths;
    }

    private void findPaths(TreeNode node, StringBuilder currentPath, List<String> resultPaths) {
        int initialLength = currentPath.length();

        if (initialLength > 0) {
            currentPath.append("->");
        }
        currentPath.append(node.val);

        if (node.left == null && node.right == null) {
            resultPaths.add(currentPath.toString());
        } else {
            if (node.left != null) {
                findPaths(node.left, currentPath, resultPaths);
            }
            if (node.right != null) {
                findPaths(node.right, currentPath, resultPaths);
            }
        }
        currentPath.setLength(initialLength);
    }
}