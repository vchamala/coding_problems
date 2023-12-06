class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] sChars = s.toCharArray();
        if (sChars.length == 0 || sChars.length == 1) {
            return sChars.length;
        }
        // better to do Queue here..
        // you remove elements until we reach char[y]
        Queue<Character> q = new LinkedList<Character>();
        int y = 0;
        int longest = 0;
        while(y<sChars.length) {
            if (q.contains(sChars[y])) {
                // remove chars until the existing char from q..
                // here we keep polling until we reach an identical element..
                while (!q.isEmpty()) {
                    if (q.peek() == sChars[y]) {
                        // now remove the identical char as well..
                        q.poll();
                        break;
                    }
                    q.poll();
                }                
            }
            q.add(sChars[y]);
            longest = Math.max(longest, q.size());
            y++;
        }
        return longest;
    }
}
