class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int i = 0, j = 0, ans = 0;
        int[][] dp = new int[matrix.length + 10][matrix.length + 10];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (i = 0; i < dp.length; i++) {
            for (j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        for (i = 0 ; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, solve(i, j, Integer.MIN_VALUE, dirs, dp, matrix));
            }
        }

        return ans;
    }

    private int solve(int i, int j, int prev, int[][] dirs, int[][] dp, int[][] matrix) {

        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length 
            || prev >= matrix[i][j]) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = 1;

        for (int[] dir : dirs) {
            ans = Math.max(ans, 1 + solve(i + dir[0], j + dir[1], matrix[i][j], dirs, dp, matrix));
        }

        return dp[i][j] = ans;
    }
}
