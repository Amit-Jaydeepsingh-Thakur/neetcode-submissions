class Solution {
    public int countSubstrings(String s) {
        int i = 0, res = 0, l = 0, r = 0;

        for (i = 0; i < s.length(); i++) {

            l = i;
            r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}
