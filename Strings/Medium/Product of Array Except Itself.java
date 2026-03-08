public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            // If the current num is not 0, include in product
            if (nums[i] != 0) {
                prod *= nums[i];
            // Else, increment number of zeros
            } else {
                countZero++;
            }
        }
        
        // If there are 2 or more zeros, every product will be zero
        if (countZero >= 2) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // If there is one zero present in the nums array
            if (countZero > 0) {
                // This is the zero position, so its result
                // is the product of all non-zero elements
                if (nums[i] == 0) {
                    result[i] = prod;
                // Else, zero exists elsewhere in the array, so this product is 0
                } else {
                    result[i] = 0;
                }
            // Divide the product by the number itself to get
            // the prod of elems except itself
            } else {
                result[i] = prod / nums[i];
            }
        }
        return result;
    }
}