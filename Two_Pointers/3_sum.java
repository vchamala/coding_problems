class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i=0; i<len-2; i++) {
            int l = i+1;
            int r = len-1;
            
            while(l<r) {
                int sum = nums[i] + nums[l] + nums[r];

                // for 3 sum to K - need to update this to K value
                if(sum==0) {
                // add these 3 elems..
                    List<Integer> num = new ArrayList<>();
                    num.add(nums[i]);
                    num.add(nums[l]);
                    num.add(nums[r]);
                    res.add(num);
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
