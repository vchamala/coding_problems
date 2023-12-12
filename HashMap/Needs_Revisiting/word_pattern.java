class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sWords = s.split(" ");
        if (pattern.length() != sWords.length) { return false; }
        Map<Character, String> patternWordMap = new HashMap<>();
        
        for (int i=0; i<pattern.length(); i++) {
            // TODO: lazy way to check.. needs revisiting..
            
            // checking if this value has been mapped to any other char key.
            if (patternWordMap.containsValue(sWords[i])) {
                for (Map.Entry<Character,String> entry: patternWordMap.entrySet()) {
                    if (entry.getValue().equals(sWords[i]) && entry.getKey() != pattern.charAt(i)) {
                        return false;
                    }
                }
            }
            
            // checking if the mapped value is same as pattern.
            if (patternWordMap.get(pattern.charAt(i)) != null) {
                if (patternWordMap.get(pattern.charAt(i)).equals(sWords[i])) {
                    continue;
                } else {
                    return false;
                }
            }
            
            // if new pattern, insert in map.
            patternWordMap.put(pattern.charAt(i), sWords[i]);
        }
        return true;
    }
}
