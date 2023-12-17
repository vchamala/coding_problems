class Solution {
    int findMaxSum(int arr[], int n) {
        // code here
        // max sum of subsequence.. but subsequence cannot have adjacent elements..
        
        // Seen.. Needs Revisiting..
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
 
        for (i = 1; i < n; i++) {
            // Current max excluding i
            excl_new = Math.max(incl, excl);
 
            // Current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }
 
        // Return max of incl and excl
        return Math.max(incl, excl);
    }
}
