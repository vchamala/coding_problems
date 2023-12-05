class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i=0; i<numbers.length; i++) {
            if (numMap.get(target-numbers[i]) != null) {
                return new int[]{numMap.get(target-numbers[i]), i+1};
            }
            numMap.put(numbers[i], i+1);
        }
        return null;
    }
}
