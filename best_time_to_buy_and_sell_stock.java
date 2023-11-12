class Solution {
    public int maxProfit(int[] prices) {
        // // BRUTE_FORCE
        // // find the largest difference between a left index and right index in the array.
        int len = prices.length;
        // int max = 0;
        // for (int i=0; i<len-1; i++) {
        //     for (int j=i+1; j<len; j++) {
        //         max = Math.max(max, prices[j]-prices[i]);
        //     }
        // }
        // return max;

        int buy = prices[0]; 
        int maxProfit = 0;

        for (int i=0; i<len; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > maxProfit) {
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }
}
