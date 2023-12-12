class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder str = new StringBuilder();
        int len = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == ' ') {
                if (len > 0) {
                    break;
                } else {
                    continue;
                }
            }
            len++;
        }
        return len;
    }
}
