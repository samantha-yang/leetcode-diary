class RandomizedSet {
    // Maps values -> index so we can remove in O(1)
    private HashMap<Integer, Integer> map;
    // Store values so we can get items in O(1)
    private List<Integer> nums;
    private Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.nums = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // Get the index of the value we want to remove
        int index = map.get(val);
        // Get the last element in the list
        int last = nums.get(nums.size() - 1);
        // Move the last element to the index of the value we want to remove
        nums.set(index, last);
        // Update the map so that the last elem now points to new index
        map.put(last, index);
        // Remove the last element (duplicate) from the list since we just move it to a new index
        nums.remove(nums.size() - 1);
        // Remove the delete value from the map
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */