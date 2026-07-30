class Solution {
    public List<List<String>> partition(String s) {
        int i = 0, j = 0;

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(0, s, list, ans);

        return ans;
    }

    private void solve(int idx, String s, List<String> list, List<List<String>> ans) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String subStr = s.substring(idx, i + 1);
            if (isPalindrome(subStr)) {
                list.add(subStr);
                solve(i + 1, s, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
