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
class Pair {
    TreeNode node;
    int weight;

    public Pair(TreeNode node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        int i = 0, j = 0, size = 0;
        List<Integer> ans = new ArrayList<>();
        //Map<Integer, TreeNode> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return ans;
        }

        q.add(root);

        while (!q.isEmpty()) {
            size = q.size();

            TreeNode levelAns = null;

            for (i = 1; i <= size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                levelAns = node;
            }

            ans.add(levelAns.val);            
        }

        return ans;
        
    }
}
