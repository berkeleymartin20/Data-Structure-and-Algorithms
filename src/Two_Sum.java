/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

/**Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

*/

import java.util.HashMap;

public class Two_Sum {

    /**
     * Given a int[] array of numbers, find two numbers that add up to the target
     * @param nums array of numbers in integer
     * @param target target sum
     * @return int[] array of two indices where the sum of nums[] array at the indices sum up to the target
     */
    public int[] twoSum(int[] nums, int target) {

        //Brute force method, that loops through each pair to see if the sum of the two meets the target
        /*for (int x = 0; x < nums.length; x++) {
            for (int y = x+1; y < nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    return new int[]{x,y};
                }
            }
        }*/

        //HashMap approach that runs at O(n) runtime
        int[] answer = new int[2];
        //First integer keeps track of the checked value of nums[] array at the index i, and the second integer keeps track of the index i
        HashMap<Integer, Integer> checked =  new HashMap<>();
        for(int x = 0; x < nums.length; x++) {
            //if the current element's complement to the target is in the hashmap "checked," then return the int[] array that contains
            //index of the current element and its complement's index.
            if (checked.containsKey(target-nums[x])) {
                answer[0] = checked.get(target-nums[x]);
                answer[1] = x;
                return answer;
            } else {
                //put the element and its index to the checked HashMap
                checked.put(nums[x],x);
            }

        }
        return null;
    }
}
