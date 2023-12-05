class Solution {
    public boolean isSubsequence(String s, String t) {
        
        // in the loop check each of s chars..
        
        if (s.length() == 0 || (s.length() == 0 && t.length() == 0)) {
            return true;
        }
        
        if (t.length() == 0 || t.length() < s.length()) {
            return false;
        }
        
        int x = 0; 
        int y = 0;
        while (y < t.length()) {
            // at this point , it means x had not reached end of s and we have not found all 
            // elements of s as subsequence in t.
            if (y==t.length()) { return false; }
            
            if (t.charAt(y) == s.charAt(x)) {
                x++;
            }
            
            // at the iteration where x had been incremented past s size, it means we found all
            // s subsequence in t..
            if (x==s.length()) { return true; }
            y++;
        }
        
        if (x != s.length()) {
            return false;
        } else {
            return true;
        }
    }
}
