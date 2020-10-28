/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

public class NumberOfIslands {
    /**
     * Returns the number of islands in an array of 1's and 0's, where 1 represents land and 0 represents water.
     * An island is 1 or more '1''s surrounded by water horizontally and vertically
     * @param grid array of 1's and 0's representing land and water respectively
     * @return return the number of islands in the grid
     */
    public static int numIslands(char[][] grid) {
        int landcount = 0;

        //loop through all of the island and if the element is equal to '1,' check if it's an island
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {

                if (grid[row][col] == '1') {
                    checkIsland(grid,row,col);
                    landcount++;
                }

            }
        }
        return landcount;

    }


    //recursive helper method that checks if the surrounding elements is land or water
    //if the element is 1, the element is set to 0 to denote that the element is a part of a counted island
    public static void checkIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
            return;
        } else {
            grid[row][col] = '0';

            checkIsland(grid,row-1,col);
            checkIsland(grid,row+1,col);
            checkIsland(grid,row,col-1);
            checkIsland(grid,row,col+1);
        }
        return;
    }
}
