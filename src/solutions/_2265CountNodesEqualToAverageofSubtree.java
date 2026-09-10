package solutions;

public class _2265CountNodesEqualToAverageofSubtree {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val;  }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int answer;

    public int averageOfSubtree(TreeNode root) {
        answer = 0;
        averageOfSubtreeHelper(root);
        return answer;
    }
    private int[] averageOfSubtreeHelper(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = averageOfSubtreeHelper(node.left);
        int[] right = averageOfSubtreeHelper(node.right);

        int sum = left[0] + right[0] + node.val;
        int quantity = left[1] + right[1] + 1;

        if (sum / quantity == node.val) answer++;

        return new int[]{sum, quantity};
    }
}
