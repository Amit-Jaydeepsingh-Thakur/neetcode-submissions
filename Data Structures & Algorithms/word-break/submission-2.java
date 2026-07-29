class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int i = 0, j = 0;
        boolean[] vis = new boolean[s.length() + 1];
        boolean[] dp = new boolean[s.length() + 1];

        return solve(0, s, dp, vis, wordDict);
    }

    private boolean solve(int i, String s, boolean[] dp, boolean[] vis, List<String> list) {
        if (i == s.length()) {
            return true;
        }

        if (i > s.length()) {
            return false;
        }

        if (vis[i]) {
            return dp[i];
        }

        for (int idx = i; idx < s.length(); idx++) {
            if (list.contains(s.substring(i, idx + 1)) && solve(idx + 1, s, dp, vis, list)) {
                vis[idx] = true;
                return dp[idx] = true;
            }
        }

        vis[i] = true;
        return dp[i] = false;
    }
}
