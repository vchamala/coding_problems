class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i=0; i<len; i++) {
            if (i < len-2 && nums[i] == nums[i+2]) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}
