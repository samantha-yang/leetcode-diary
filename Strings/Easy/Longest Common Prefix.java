class Solution {
    public String longestCommonPrefix(String[] strs) {
        // If the array of words is empty or null, there is no common prefix
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Initialize the prefix as the first string
        String prefix = strs[0];

        // Compare the prefix to each word
        for (String s : strs) {
            // While the current string does NOT start with the prefix
            while (s.indexOf(prefix) != 0) {
                // Shorten the prefix by removing the last char
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        
        // Return the longest common prefix
        return prefix;
    }
}

// Think of the while loop as:
// Go through words
//      Is the prefix still a valid starting piece of the word? If no:
//          Cut off the last letter of the prefix and try again