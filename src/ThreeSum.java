import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */

public class ThreeSum {
    /**
     * Dynamic programming solution to a sum of three numbers that equal to 0 in an array to integers
     * @param nums numbers in integers
     * @return return lists of numbers that sum up to numbers in a nested ArrayList format
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        //Sorting the array for the dynamic programming solution. This allows us to move the pointers easily and ocrrectly.
        Arrays.sort(nums);

        if (nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        //two pointers with one at the element after the first number and the last number of the array.
        //the pointers move depending on the sum - if the number is bigger than 0, make the sum smaller by moving the right poitner to the left
        //move the left pointer to the right if the sum is smaller than 0
        for (int x = 0; x < nums.length - 2; x++) {
            int y = x + 1;
            int z = nums.length - 1;


            //if the sum is equal to 0, add to the HashSet. Then move the pointers accordingly until the pointers are either pointing
            //to the same element or if they are adjacent to each other
            while (y < z) {
                if (nums[x] + nums[y] + nums[z] == 0) {
                    answer.add(Arrays.asList(nums[x],nums[y],nums[z]));
                    y++;
                    z--;
                } else{
                    if(nums[x] + nums[y] + nums[z] > 0) {
                        z--;
                    } else {
                        y++;
                    }
                }
            }
        }
        return new ArrayList<>(answer);
    }
}
