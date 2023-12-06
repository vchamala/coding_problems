class Solution {
    public int strStr(String haystack, String needle) {
        // if needle is larger - return -1
        if (needle.length() > haystack.length()) {
            return -1;
        }
        // if both strings are empty - return 0
        if (needle == "" && haystack == "") {
            return 0;
        }
        
        int i=0;
        int j=0;
        while (i<haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int x = i+1;
                int y = j+1;
                while (y < needle.length() && x < haystack.length()) {
                    if (haystack.charAt(x) == needle.charAt(y)) {
                        x++;
                        y++;
                    } else {
                        break;
                    }
                }
                if (y == needle.length()) { return i; } 
            }
            i++;
        }
        return -1;
    }
}
