class Solution {
    public boolean canPartition(int[] nums) {
        int i = 0, j = 0, sum = 0;

        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length][sum/2 + 1000];
        boolean[][] vis = new boolean[nums.length][sum/2 + 1000];


        return solve(0, sum / 2, dp, vis, nums);
    }

    private boolean solve(int i, int target, boolean[][] dp, boolean[][] vis, int[] nums) {
        if (i == nums.length || target < 0) {
            return false;
        }

        if (vis[i][target]) {
            return dp[i][target];
        }

        if (target == 0) {
            return true;
        }

        boolean take = solve(i + 1, target - nums[i], dp, vis, nums);
        boolean notTake = solve(i + 1, target, dp, vis, nums);

        vis[i][target] = true;

        return dp[i][target] = take || notTake;
    }
}
