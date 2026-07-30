class Solution {
    public List<String> letterCombinations(String digits) {
        int i = 0, j = 0;
        Map<Character, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        if (digits.isEmpty()) {
            return list;
        }

        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, "", digits, map, list);

        return list;
    }

    private void solve(int idx, String res, String digits, Map<Character, String> map, List<String> list) {
        if (res.length() == digits.length()) {
            list.add(res);
            return;
        }

        String s = map.get(digits.charAt(idx));

        for (char ch : s.toCharArray()) {
            solve(idx + 1, res + ch, digits, map, list);
        }

        
    }
}
