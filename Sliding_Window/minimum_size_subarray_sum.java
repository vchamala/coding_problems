class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        // TODO - Please see: There is a Bug - Need to update for accurate solution.
        
        // sliding window x and y
        
        // keep moving y - when it goes past target - increment x 
        // take the minimum of the subArray lengths which 
        // satisfied the condition..
        
        int i=0;
        int j=1;
        int minLength = 1;
        Queue<Integer> subArrayQueue = new LinkedList<Integer>();
        subArrayQueue.add(nums[0]);
        int currentCount = nums[0];
        
        while(i<j && j<nums.length) {
            if (currentCount >= target) {
                minLength = Math.min(minLength, subArrayQueue.size());
                currentCount = currentCount - nums[i];
                // removes the first inserted - FIFO.
                subArrayQueue.remove();
                i++;
                continue;
            } else {
                currentCount = currentCount + nums[j];
                // Inserts at the end of queue.
                subArrayQueue.add(nums[j]);
                minLength = subArrayQueue.size();
                j++;
            }  
        }
        return minLength;
    }
}
