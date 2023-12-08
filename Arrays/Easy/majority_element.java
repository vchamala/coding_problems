class Solution {
    public int majorityElement(int[] nums) {
        // merge sort    
        merge(nums, 0, nums.length-1);
        
        // return the mid element.. this will definitely be the more than n/2 times occuring element..
        int mid = (nums.length-1)/2;
        return nums[mid];
    }
    
    private void merge(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l+(r-1)/2;
            merge(arr, l, mid);
            merge(arr, mid+1, r);
            mergeSort(arr, l, mid, r);
        }
    }
    
    private void mergeSort(int[] arr, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        
        int[] A1 = new int[n1];
        int[] A2 = new int[n2];
        
        for (int i=0; i<n1; i++) {
            A1[i] = arr[l+i];
        }
        
        for (int j=0; j<n2; j++) {
            A2[j] = arr[mid+1+j];
        }
        
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2) {
            if (A1[i]<=A2[j]) {
                arr[k] = A1[i];
                i++;
                k++;
            } else {
                arr[k] = A2[j];
                j++;
                k++;
            }
        }
        
        //finish A1
        while(i<n1) {
            arr[k]=A1[i];
            i++;
            k++;
        }
        
        //finish A2
        while(j<n2) {
            arr[k]=A2[j];
            j++;
            k++;
        }
    }
}
