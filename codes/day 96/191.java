class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[4 * n];
            buildTree(nums, 0, 0, n - 1);
        }
    }

    private void buildTree(int[] nums, int treeIndex, int start, int end) {
        if (start == end) {
            tree[treeIndex] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildTree(nums, 2 * treeIndex + 1, start, mid);
        buildTree(nums, 2 * treeIndex + 2, mid + 1, end);
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public void update(int index, int val) {
        updateTree(0, 0, n - 1, index, val);
    }

    private void updateTree(int treeIndex, int start, int end, int arrIndex, int val) {
        if (start == end) {
            tree[treeIndex] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (arrIndex <= mid) {
            updateTree(2 * treeIndex + 1, start, mid, arrIndex, val);
        } else {
            updateTree(2 * treeIndex + 2, mid + 1, end, arrIndex, val);
        }
        tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
    }

    public int sumRange(int left, int right) {
        return queryTree(0, 0, n - 1, left, right);
    }

    private int queryTree(int treeIndex, int start, int end, int queryLeft, int queryRight) {
        if (end < queryLeft || start > queryRight) return 0;
        if (queryLeft <= start && end <= queryRight) return tree[treeIndex];
        int mid = start + (end - start) / 2;
        int leftSum = queryTree(2 * treeIndex + 1, start, mid, queryLeft, queryRight);
        int rightSum = queryTree(2 * treeIndex + 2, mid + 1, end, queryLeft, queryRight);
        return leftSum + rightSum;
    }
}