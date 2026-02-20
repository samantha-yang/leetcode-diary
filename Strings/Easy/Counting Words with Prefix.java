class Solution {
    public int prefixCount(String[] words, String pref) {
        // Keep track of number of words
        int count = 0;
        
        // Iterate through the words array
        for (int i = 0; i < words.length; i++) {
            // If the prefix is less than or equal to the length of the word
            if (pref.length() <= words[i].length()) {
                // If the word's prefix equals the given prefix
                if (words[i].substring(0, pref.length()).equals(pref)) {
                    // Increment count
                    count++;
                }
            }
        }

        // Return number of words
        return count;
    }
}