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
    public int maxPathSum(TreeNode root) {
        int i = 0, j = 0;
        int[] res = new int[]{root.val};

        solve(root, res);

        return res[0];
    }

    private int solve(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(solve(root.left, res), 0);
        int right = Math.max(solve(root.right, res), 0);

        res[0] = Math.max(res[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
