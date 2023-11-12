class Solution {
    public int longestConsecutive(int[] nums) {
        // IMPORTANT: Below will be solution if we are getting sorted incrementing list ...
    
        // Sort the array to incrementing order.
        Arrays.sort(nums);
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            // if there is a previous number present in map - replace it and increment the value counter.
            if (numsMap.containsKey(nums[i]-1)) {
                int consSequenceCounterValue = numsMap.get(nums[i]-1);
                numsMap.remove(nums[i]-1);
                numsMap.put(nums[i], consSequenceCounterValue+1);
            } else {
                numsMap.put(nums[i], 1);
            }
        }
        return Collections.max(numsMap.entrySet(), Map.Entry.comparingByValue()).getValue();
    }
}
