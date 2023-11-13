class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int j=0;
        for (int i=0; i<len; i++) {

            if (i<len-1 && nums[i] == nums[i+1]) {  
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}
