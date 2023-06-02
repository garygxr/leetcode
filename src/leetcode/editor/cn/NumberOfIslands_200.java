//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1844 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author gary gan
 * @date 2022-08-11 13:52:37
 */
public class NumberOfIslands_200 {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands_200().new Solution();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int i = solution.numIslands(grid);
        System.out.println(i);
    }

    /**
     * 岛屿数量
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            //  boolean[][] land = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        bfdFindLand(i, j, grid);
                        count++;
                    }
                }
            }
            return count;
        }

        public void bfdFindLand(int r, int c, char[][] grid) {
            int nr = grid.length;
            int nc = grid[0].length;
            grid[r][c] = '0';
            Queue<Integer> neighbors = new LinkedList<>();
            neighbors.add(r * nc + c);
            while (!neighbors.isEmpty()) {
                int id = neighbors.remove();
                int row = id / nc;
                int col = id % nc;
                if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                    neighbors.add((row - 1) * nc + col);
                    grid[row - 1][col] = '0';
                }
                if (row + 1 < nr && grid[row + 1][col] == '1') {
                    neighbors.add((row + 1) * nc + col);
                    grid[row + 1][col] = '0';
                }
                if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                    neighbors.add(row * nc + col - 1);
                    grid[row][col - 1] = '0';
                }
                if (col + 1 < nc && grid[row][col + 1] == '1') {
                    neighbors.add(row * nc + col + 1);
                    grid[row][col + 1] = '0';
                }
            }
        }

        public void dfsFindLand(int i, int j, char[][] grid) {
            if (i >= grid.length || i < 0) {
                return;
            }
            if (j >= grid[0].length || j < 0) {
                return;
            }
            if (grid[i][j] == '0') {
                return;
            }
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
            }
            dfsFindLand(i + 1, j, grid);
            dfsFindLand(i - 1, j, grid);
            dfsFindLand(i, j + 1, grid);
            dfsFindLand(i, j - 1, grid);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}


