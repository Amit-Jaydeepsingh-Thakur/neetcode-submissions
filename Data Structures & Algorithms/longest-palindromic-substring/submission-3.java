class Solution {
    public String longestPalindrome(String s) {
        int i = 0, j = 0, maxLen = 0;
        String ans = "";

        for (i = 0 ; i < s.length(); i++) {
            for (j = i; j < s.length(); j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    if (s.substring(i, j + 1).length() > maxLen) {
                        ans = s.substring(i, j + 1);
                        maxLen = s.substring(i, j + 1).length();
                    }
                    //ans = Math.max(ans, );
                }
            }
        }

        return (ans.equals("") ? s : ans);
        
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        } 

        return true;
    }
}
