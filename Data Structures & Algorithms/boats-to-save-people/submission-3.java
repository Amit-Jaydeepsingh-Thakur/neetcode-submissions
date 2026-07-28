class Solution {
    public int numRescueBoats(int[] nums, int limit) {
        int ans = 0, r = nums.length - 1, l = 0, i = 0, j = 0;
        Arrays.sort(nums);

        while (l <= r) {
            if (nums[l] + nums[r] <= limit) {
                l++;
                r--;
                //ans++;
                //System.out.println("Here3" + " " + nums[l] + " " + nums[r]);
            } else {
                r--;
                //System.out.println("Here4");
            }
            ans++;
        }

        return ans;
        
    }
}