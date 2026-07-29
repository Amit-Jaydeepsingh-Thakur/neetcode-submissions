class Solution {
    public int lengthOfLIS(int[] nums) {
        int i = 0, j = 0;
        int[][] dp = new int[nums.length + 3][nums.length + 3];

        for (i = 0 ; i < dp.length; i++) {
            for (j = 0 ;j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, -1, dp, nums);
    }

    private int solve(int idx, int prev, int[][] dp, int[] nums) {
        if (idx == nums.length) {
            return 0;
        }

        if (dp[idx][prev + 1] != -1) {
            return dp[idx][prev + 1];
        }

        int take = 0, not_take = 0;

        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + solve(idx + 1, idx, dp, nums);
        }

        not_take = solve(idx + 1, prev, dp, nums);

        return dp[idx][prev + 1] = Math.max(take, not_take);
    }
}
