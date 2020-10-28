/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees with O(1) space(clockwise).
 *
 * Example 1:=
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */

public class Rotate_Image {
    /**
     * NOTE: Another method that uses O(n) space, where n is the number of elements, would be to place
     * the first row in the last column, 2nd row to the second to last column and so on.
     * This method would allow us to return a rotated array if the given array is an n x m array where n != m
     */
    /**
     * Use the nxn matrix rotation algorithm to rotate the matrix in place (clockwise)
     * The algorithm rotates the matrix in rings
     *
     * @param a 2D matrix of integers
     */
    public void rotate(int[][] a) {
        int N = a.length;

        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }

    }
}
}
