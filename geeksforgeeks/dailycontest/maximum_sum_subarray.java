
//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        int i = 0;
        int j = 1;
        int maxSum = 0;
        int currentSum = 0;
        while (i<=(N-K)) {
            currentSum = Arr.get(i);
            while (j-i <= K-1) {
                currentSum = currentSum + Arr.get(j);
                j++;
            }
            maxSum = Math.max(maxSum, currentSum);
            currentSum = 0;
            i++;
            j = i+1;
        }
        return maxSum;
    }
}
