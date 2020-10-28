import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */

public class kth_Largest_Element {

    /**
     * Find kth largest element of the array O(nlogn)
     *
     * @param nums list of numbers
     * @param k for kth largest element
     * @return return kth largest element in integer
     */
    public int findKthLargest(int[] nums, int k) {

        //Sort the array in O(nlogn) time and retrieve the kth from the end element O(1)
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
