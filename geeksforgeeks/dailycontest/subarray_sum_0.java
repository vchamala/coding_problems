class Solution{
    // <<<<<<<<<<  NOTE: Improved Brute Force  >>>>>>>>>>
  
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        int sum=0;
        for (int i=0; i<n-1; i++) {
            sum+=arr[i];
            if (sum==0) {
                return true;
            }
            for (int j=i+1; j<n; j++) {
                sum+=arr[j];
                if (sum==0) {
                    return true;
                }
            }
            sum=0;
        }
        return false;
    }
}

