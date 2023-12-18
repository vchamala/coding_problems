class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        // Needs revisiting for an optimized solution.. Executes merge sort currently..
        merge(a, 0, n);
    }
    
    public static void merge(int[] a, int l, int r) {
        while (l<r) {
            int mid = l+(r-1)/2;
            merge(a, l, mid);
            merge(a, mid+1, r);
            mergeSort(a, l, mid, r);
        }
    }
    
    public static void mergeSort(int[] a, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        
        int[] A1 = new int[n1];
        int[] A2 = new int[n2];
        
        for(int i=0; i<n1; i++) {
            A1[i] = a[i];
        }
        
        for(int j=0; j<n2; j++) {
            A1[j] = a[mid+1+j];
        }
        
        int i=0; int j=0; int k=l;
        while(i<n1 && j<n2) {
            if (A1[i] <= A2[j]) {
                a[k] = A1[i];
                i++;
            } else {
                a[k] = A2[j];
                j++;
            }
            k++;
        }
        
        while(i<n1) {
            a[k] = A1[i];
        }
        
        while(j<n2) {
            a[k] = A2[j];
        }
    }
}
