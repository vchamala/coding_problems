class Solution {
    public boolean isAnagram(String s, String t) {
        // RED - TODO: NEEDS IMPROVING TIME COMPLEXITY..
      
        if (s.length() != t.length()) { return false; }
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        for (int i=0; i<s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                int count = sMap.get(s.charAt(i));
                count++;
                sMap.put(s.charAt(i), count);
                continue;
            }
            sMap.put(s.charAt(i), 1);
        }
        
        for (int j=0; j<t.length(); j++) {
            if (sMap.containsKey(t.charAt(j))) {
                int count = sMap.get(t.charAt(j));
                if (count==1) {
                    sMap.remove(t.charAt(j));
                    continue;
                }
                count--;
                sMap.put(t.charAt(j), count);
            } else { 
                return false;
            }
        }
        
        return sMap.isEmpty();
    }
}
