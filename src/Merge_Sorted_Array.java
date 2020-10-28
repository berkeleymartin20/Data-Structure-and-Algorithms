/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Example:
 * Input: nums1 = [1,2,3,0,0,0], m = 3  nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */

import java.util.Arrays;

public class Merge_Sorted_Array {
    /**
     * merge the sorted arrays with O(1) space
     * @param nums1 first array
     * @param m length of first array
     * @param nums2 second array
     * @param n length of second array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
