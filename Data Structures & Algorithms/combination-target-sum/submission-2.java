class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int i = 0, j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(0, nums, target, list, ans);

        return ans;
        
    }

    private void solve(int idx, int[] nums, int target, List<Integer> list, List<List<Integer>> ans) {

        if (target == 0 && !ans.contains(list)) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (idx >= nums.length || target < 0) {
            return;
        }

        list.add(nums[idx]);
        solve(idx, nums, target - nums[idx], list, ans);
        list.remove(list.size() - 1);
        solve(idx + 1, nums, target, list, ans);
    }   
}
