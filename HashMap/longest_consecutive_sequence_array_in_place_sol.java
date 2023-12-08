class Solution {
    public int longestConsecutive(int[] nums) {
        // sort the array .. and keep count of sequent numbers and 
        // length of sequence, highestLength..
        if (nums.length == 0 || nums.length == 1) { return nums.length; }
        Arrays.sort(nums);
        int highestLength = 0;
        int consLength = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i+1] - nums[i] == 1) {
                // if first element of sequence.. include that too and make count as 2..
                if (consLength==0) {
                    consLength = consLength+2;
                // for regular cases, only incement..    
                } else {
                    consLength++;
                }
            } else if (nums[i+1] == nums[i]) {
                continue;
            } else {
                highestLength = Math.max(consLength, highestLength);
                consLength = 0;
            }
        }
        return highestLength == 0 && consLength == 0 ? 1: Math.max(consLength, highestLength);
    }
}
