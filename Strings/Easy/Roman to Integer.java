class Solution {
    public int romanToInt(String s) {
        // Create a map that maps roman numerals to their values
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1); roman.put('V', 5);
        roman.put('X', 10); roman.put('L', 50);
        roman.put('C', 100); roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;
        // Iterate through the string and get each numeral
        for (int i = 0; i < s.length(); i++) {
            // If the curr numeral is less than the next one
            // then subtract that amount from result
            if (i + 1 < s.length() && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                result -= roman.get(s.charAt(i));
            // Otherwise add it
            } else {
                result += roman.get(s.charAt(i));
            }
        }
        return result;
    }
}