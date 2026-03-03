public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Keep track of chars in our window
        HashSet<Character> charSet = new HashSet<>();
        // Set left pointer of the sliding window
        int l = 0;
        // Stores the max length found so far
        int maxLength = 0;

        // Right pointer to expand the window
        for (int r = 0; r < s.length(); r++) {
            // If the set contains the current char, remove it and increase window
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            // Add the char to the set
            charSet.add(s.charAt(r));
            // Update the max length with the current window size if it is larger
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}