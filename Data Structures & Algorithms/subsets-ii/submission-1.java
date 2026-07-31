class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        solve(0, nums, list, ans);

        return ans;
    }

    private void solve(int idx, int[] nums, List<Integer> list, List<List<Integer>> ans) {
        
        if (!ans.contains(list))
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            // if (i > 0 && nums[i] == nums[i - 1]) {
            //     continue;
            // }

            list.add(nums[i]);
            solve(i + 1, nums, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
