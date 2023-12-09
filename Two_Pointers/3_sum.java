class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i=0; i<len-2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i+1;
            int r = len-1;
            
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0) {
                // add these 3 elems..
                    List<Integer> num = new ArrayList<>();
                    num.add(nums[i]);
                    num.add(nums[l]);
                    num.add(nums[r]);
                    res.add(num);
                    
                    // Skip duplicate elements for j
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    // Skip duplicate elements for k
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    // Move the pointers
                    l++;
                    r--;
                }
            
                if (sum>0) {
                    r--;
                }
                
                if (sum<0) {
                    l++;
                }
            }
        }
        return res;
    }
}
