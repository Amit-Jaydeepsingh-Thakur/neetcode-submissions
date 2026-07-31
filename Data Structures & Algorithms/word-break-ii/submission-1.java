class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int i = 0, j = 0;
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        solve(0, s, sb, wordDict, ans);

        return ans;
    }

    private void solve(int idx, String s, StringBuilder sb, List<String> list, List<String> ans) {
        if (idx >= s.length()) {
            ans.add(sb.toString().trim());
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (list.contains(s.substring(idx, i + 1))) {
                String last = s.substring(idx, i + 1) + " ";
                sb.append(last);
                solve(i + 1, s, sb, list, ans);
                sb.delete(sb.length() - last.length(), sb.length());
            }

        }
    }
}