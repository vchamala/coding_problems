class Solution {
    public int minSubArrayLen(int target, int[] nums) {        
        // sliding window i and j
        // keep moving y - when it goes past target - increment i 
        // take the minimum of the subArray lengths which 
        // satisfied the condition..
        int i=0;
        int j=0;
        int currentCount=0;
        int ans = Integer.MAX_VALUE;
        while(j<nums.length) {
            currentCount = currentCount + nums[j];
            while (currentCount >= target) {
                int len = j-i+1;
                if (len < ans) {
                    ans = len;
                }
                currentCount = currentCount - nums[i];
                i++;
            } 
            j++;
        }
        if(ans == Integer.MAX_VALUE){
            ans = 0;
        }
        return ans;
    }
}
