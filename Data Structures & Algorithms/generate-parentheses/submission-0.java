class Solution {
    public List<String> generateParenthesis(int n) {
        int i = 0, j = 0, total = 2 * n;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        solve(0, 0, total, sb, list);

        return list;
    }

    private void solve(int left, int right, int total, StringBuilder sb, List<String> list) {

        if (left > total || right > total || right > left) {
            return;
        }

        if (left == right 
            && !sb.toString().isEmpty()
            && sb.toString().length() == total) {
            list.add(sb.toString().trim());
            return;
        }

        if (left < total) {
            sb.append("(");
            solve(left + 1, right, total, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append(")");
            solve(left, right + 1, total, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
