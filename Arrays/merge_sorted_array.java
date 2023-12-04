class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] mergedNums = new int[m+n];
        int x=0; 
        int y=0;
        int k=0;
        while (x < m && y < n) {
            if (nums1[x] <= nums2[y]) {
                mergedNums[k] = nums1[x];
                k++;
                x++;
            } else {
                mergedNums[k] = nums2[y];
                k++;
                y++;
            }
        }
        
        // finish all in list 1
        while (x<m) {
            mergedNums[k] = nums1[x];
            k++;
            x++;
        }
        
        // finish all in list 2
        while (y<n) {
            mergedNums[k] = nums2[y];
            k++;
            y++;
        }
        
        for (int i=0; i<mergedNums.length; i++) {
            nums1[i] = mergedNums[i];
        }
        
    }
}
