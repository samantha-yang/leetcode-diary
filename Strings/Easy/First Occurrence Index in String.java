class Solution {
    public int occurrenceIndex(String haystack, String needle) {
        // If the length of the needle is longer than the haystack, return -1 since
        // it will not occur in the haystack
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // Iterate through the haystack and check if the chars from i to the length of
        // the needle + i match the needle string
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, needle.length() + i).equals(needle)) {
                return i;
            }
        }

        // Return -1 if there are no matches
        return -1;
    }
}

// Be careful of off by one error in for loop
// Make sure to draw out a picture