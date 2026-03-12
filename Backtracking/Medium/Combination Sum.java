public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> current = new ArrayList();
        backtrack(nums, target, current, 0);
        return result;
    }

    public void backtrack(int[] nums, int target, List<Integer> current, int i) {
        // Base case: combination sums to target, save a snapshot of current
        if (target == 0) {
            result.add(new ArrayList(current));
            return;
        }

        // Base case: gone negative or exhausted all candidates
        if (target < 0 || i >= nums.length) {
            return;
        }
        // Choice 1: pick nums[i] and recurse with reduced target.
        // Passing i (not i+1) allows nums[i] to be reused in future calls.
        current.add(nums[i]);
        backtrack(nums, target - nums[i], current, i);

        // Undo the choice above before exploring the next branch
        current.remove(current.size() - 1);

        // Choice 2: skip nums[i] entirely and move to the next candidate
        backtrack(nums, target, current, i + 1);
    }
}