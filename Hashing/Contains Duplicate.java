public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Use a HashSet to store unique elements
        HashSet<Integer> set = new HashSet<>();
        // Iterate through the array element by element
        for (int num : nums) {
            // If the set contains the element, it means there is a duplicate
            if (set.contains(num)) {
                return true;
            }
            // Else, then we add the element to the set
            set.add(num);
        }
        return false;
    }
}