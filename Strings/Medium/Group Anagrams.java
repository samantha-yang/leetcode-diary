class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        
        // Go through string array of given words
        for (String s : strs) {
            // Array of 26 to count frequency of chars
            int[] count = new int[26];

            // Increment the count for each character
            // Subtracting 'a' maps: a->0, b->1, c->2, ... z->25
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Convert frequency array to a string to use as a HashMap key
            String key = Arrays.toString(count);

            // If key hasn't been seen, put it and create new list
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            // Add current word to its anagram group
            result.get(key).add(s);
        }

        // Return all anagram lists
        return new ArrayList<>(result.values());
    }
}
