class Solution {
    public int[] productExceptSelf(int[] nums) {
      // no division operation allowed
      // needs O(n) time solution
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);
        int curr = 1;
        for (int i=0; i<n; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i=n-1; i>=0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }
}
