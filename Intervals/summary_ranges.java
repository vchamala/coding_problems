class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> rangeStrings = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int start;
            int end;
            start = nums[i];
            while(i+1 < nums.length && nums[i]+1 == nums[i+1]) {
                i++;
            }
            end = nums[i];

            if (start==end) {
                rangeStrings.add(String.valueOf(start));
            } else {
                rangeStrings.add(String.valueOf(start) + "->" + String.valueOf(end));
            }
        }
        return rangeStrings;
    }
}
