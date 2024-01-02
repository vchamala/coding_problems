class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // sliding window..
        // check until k for each index..
        int len = nums.length;
        int i=0;
        while (i<len) {
            int j=i+1;
            int x=1;
            while(x<=k && j<len) {
                if (nums[i]==nums[j]) {
                    return true;
                }
                x++;
                j++;
            }
            i++;
        }
        return false;
    }
  // TIME LIMIT EXCEEDED
}


// O(n) time complexity
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // save in HashSet..
        // always maintain k elements in HashSet..
// keep checking in HashSet for duplicate.. if crosses.. remove (i-k)th element
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
