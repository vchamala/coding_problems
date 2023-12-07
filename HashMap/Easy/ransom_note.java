class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCharCount = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            if (magazineCharCount.containsKey(magazine.charAt(i))) {
                int count = magazineCharCount.get(magazine.charAt(i));
                count++;
                magazineCharCount.put(magazine.charAt(i), count);
            } else {
                magazineCharCount.put(magazine.charAt(i), 1);
            }
        }
        
        for (int i=0; i<ransomNote.length(); i++) {
            if (!magazineCharCount.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                if (magazineCharCount.get(ransomNote.charAt(i)) > 0) {
                    int count = magazineCharCount.get(ransomNote.charAt(i));
                    count--;
                    magazineCharCount.put(ransomNote.charAt(i), count);
                } else {
                    magazineCharCount.remove(ransomNote.charAt(i));
                    return false;
                }
            }
        }
        return true;
    }
}
