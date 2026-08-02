class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();

        for (right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (set.contains(ch)) {
                while (set.contains(s.charAt(right)) && left < right) {
                    //System.out.println(s.charAt(left));
                    set.remove(s.charAt(left));
                    left++;
                }

                //System.out.println(left + " " + right);
            } 

            set.add(s.charAt(right));
            max = Math.max(Math.abs(left - right) + 1, max);
        }

        return max;
    }
}
