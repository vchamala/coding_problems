class Solution {
    static int singleElement(int[] a , int n) {
        // code here
        if(n==1)
        return a[0];
        Arrays.sort(a);
        int c=1;
        for(int i=1;i<n;i++){
            if(a[i]==a[i-1]) {
                c++;
            } else {
                if(c==3) {
                    if(i==n-1) {
                        return a[i];
                    }    
                    c=1;
                    continue;
                }
                else {
                    return a[i-1];
                }
            }
        }
        return 1;
    }
}
