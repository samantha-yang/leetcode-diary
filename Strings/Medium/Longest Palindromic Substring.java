/*
 * Problem: Longest Palindromic Substring (LC 5)
 * Pattern: Expand Around Center
 * Technique: Two pointers expanding outward from every index
 * Time: O(n^2) - for each of n centers, we expand up to n times
 * Space: O(1) - auxilary, O(n) - output string
 * 
 * Key insight: every palindrome has a center, so if we try every possible
 * center and expand outward while characters match, we're guaranteed to
 * find the longest one.
 *
 * Pitfall: palindromes can be odd or even length, so you need two
 * expansions per center to cover both cases.
 */

class Solution {
    public String longestPalindrome(String s) {
        // Track the start index and length of the longest palindrome found so far
        int bestLen = 0;
        int bestStart = 0;

        // Try every character as a potential palindrome center
        for (int center = 0; center < s.length(); center++) {

            // Odd-length: both pointers start on the same character
            int left = center;
            int right = center;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int currentLen = right - left + 1;
                // Update best if this is the longest palindrome seen so far
                if (currentLen > bestLen) {
                    bestStart = left;
                    bestLen = currentLen;
                }
                // Expand outward one step in each direction
                left--;
                right++;
            }

            // Even-length: right starts one ahead to check a pair of characters first
            left = center;
            right = center + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int currentLen = right - left + 1;
                // Update best if this is the longest palindrome seen so far
                if (currentLen > bestLen) {
                    bestStart = left;
                    bestLen = currentLen;
                }
                // Expand outward one step in each direction
                left--;
                right++;
            }
        }

        // Return the longest palindrome substring using its saved start and length
        return s.substring(bestStart, bestStart + bestLen);
    }
}