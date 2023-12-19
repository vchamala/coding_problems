class Solution {
    public String reverseWords(String s) {
        // MESSILY WRITTEN.. NEEDS REVISITING.
      
        String st = s.trim();
        String[] words = st.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = words.length-1; i>=0; i--) {
            String m = words[i].trim();
            boolean spaces = true;
            for (int x = 0; x < m.length(); x++) {
                char c = m.charAt(x);
                // Check whether the character does not satisfy for whitespace
                if (!Character.isWhitespace(c)) {
                    spaces = false;
                    break;
                }
            }
            if (spaces) { continue; }
            
            if (i==0) {
                res.append(m);
                break;
            }
            res.append(m + " ");
        }
        return res.toString();
    }
}
