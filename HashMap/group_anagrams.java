class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         
        // assuming here that there are no duplicate letters in the word
        int len = strs.length;
        List<List<String>> anagramsList = new ArrayList<>();
        Map<String, List<String>> wordsMap = new HashMap<>();
        for (int i=0; i<len; i++) {
            String word = strs[i];
            char[] strsCharArray = word.toCharArray();
            Arrays.sort(strsCharArray);
            String sortedWord = new String(strsCharArray);
            if (wordsMap.containsKey(sortedWord)) {
                wordsMap.get(sortedWord).add(word);            
            } else {
                List<String> wordList = new ArrayList<>();
                wordList.add(word);
                wordsMap.put(sortedWord, wordList);
            }
        }

        for (List<String> value: wordsMap.values()) {
            // add each List as a separate element in anagramsList.
            anagramsList.add(value);
        }
        return anagramsList;
    }
}
