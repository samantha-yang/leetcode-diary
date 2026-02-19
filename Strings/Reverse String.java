public class Solution
    public String reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Store the character of the left pointer
            char temp = s[left];
            // Set the char at the left pointer to be the one at the right pointer
            s[left] = s[right];
            // Set the char at the right pointer to be the one at the left
            s[right] = temp;
            // Increment and decrement left and right pointers
            left++;
            right--;
        }

    }

    // Algorithm: two pointer
    // Intuition: since you want to meet in the middle, using the two pointer method helps