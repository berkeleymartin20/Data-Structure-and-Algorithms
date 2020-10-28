/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [0]
 * Output: 0
 */

public class Max_Subarray {
    /**
     * Find the subarray with the maximum sum using the sliding window algorithm
     *
     * @param nums given array with integer elements
     * @return return the largest sum possible from a subarray
     */
    public int maxSubArray(int[] nums) {
        if( nums.length == 1) {
            return nums[0];
        }
        //initialize curr and sum variables with the first element of the array. Sum is the current max sum of the subarray
        int curr = nums[0];
        int sum = nums[0];

        //loop through the given array. Set the current max (curr) to the max between current number and current number + current sum
        //if the current sum is bigger than the next sum, set the max sum to the current sum
        //otherwise, set the current max to the next number
        for (int x = 1; x < nums.length; x++) {
            curr = Math.max(nums[x], nums[x] + curr);
            if (sum < curr) {
                sum = curr;
            }
        }
        return sum;

    }
}
