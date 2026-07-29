class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int i = 0 ; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 1, dp, prices);
    }

    private int solve(int i, int flag, int[][] dp, int[] prices) {
        if (i == prices.length) {
            return 0;
        }

        if (dp[i][flag] != -1) {
            return dp[i][flag];
        }

        int buy = 0, sell = 0;
        int res = solve(i + 1, flag, dp, prices);
        if (flag == 1) {
            buy = -prices[i] + solve(i + 1, flag - 1, dp, prices);
            res = Math.max(buy, res);
        } else {
            sell = prices[i] + solve(i + 1, flag + 1, dp,prices);
            res = Math.max(res, sell);
        }

        return dp[i][flag] = res;
    }
}