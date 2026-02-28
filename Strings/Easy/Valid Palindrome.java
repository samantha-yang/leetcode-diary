class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // While left pointer has not reached right pointer and skip
            // the left char if it is not a alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // While left pointer has not reached right pointer and skip
            // the right char if it is not a alphanumeric character
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // If the char at the left does not equal the one at the right, return false
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            // Else, move pointers closer to the middle
            left++;
            right--;
        }
        return true;
    }
}