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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[1];
        List<Integer> list = new ArrayList<>();

        solve(root, ans, list);

        return list.get(k - 1);
    }

    private void solve(TreeNode root, int[] ans, List<Integer> list) {

        if (root == null) {
            return;
        }

        solve(root.left, ans, list);
        list.add(root.val);
        solve(root.right, ans, list);
    }
}
