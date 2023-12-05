class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int valReplaced = 0;        
        // we keep moving the val value to next variables .. 
        int x=0;
        while(x<=len-1) {
            if (nums[x] == val) {
                int y=len-1;
                while (y>x && nums[y] == val) {
                    y--;
                }
                int temp = nums[y];
                nums[y] = nums[x];
                nums[x] = temp;
            }
            x++;
        }
        
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == val) {
                break;
            }
            valReplaced++;
        }
        return valReplaced;
    }
}
