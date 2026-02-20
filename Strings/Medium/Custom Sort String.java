public class Solution {
    public String customSortString(String order, String s) {
        // Create a rank array to store the rank of each character in the order string
        int[] rank = new int[26];
        // Iterate through the order string and assign a rank to each character
        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i + 1;
        }
        // Create an array of characters from the input string s
        Character[] arr = new Character[s.length()];
        // Iterate through the input string s and fill the character array
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        // Sort the character array based on the rank of each character
        Arrays.sort(arr, (a, b) -> rank[a - 'a'] - rank[b - 'a']);

        // Build the resulting string
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }
}