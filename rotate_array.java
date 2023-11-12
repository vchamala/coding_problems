class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int[] tmp = new int[len];

        // generate a new tmp array.
        for (int i=0; i<nums.length; i++) {
            if (i<k) {
                tmp[i] = nums[i+len-k];
            }
            if (i >= k) {
                tmp[i] = nums[i-k];
            }
        }

        // now populate original array with same elements as tmp array.
        for (int i=0; i<len; i++) {
            nums[i] = tmp[i];
        }
    }
}
