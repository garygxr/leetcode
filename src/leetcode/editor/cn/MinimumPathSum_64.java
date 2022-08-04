//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1298 👎 0

package leetcode.editor.cn;

/**
 * @author gary gan
 * @date 2022-07-24 10:14:37
 */
public class MinimumPathSum_64 {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum_64().new Solution();
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int i = solution.minPathSum(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int l = 0; l < grid[0].length; l++) {
                    int a = Integer.MAX_VALUE;
                    int b = Integer.MAX_VALUE;
                    if (i == 0 && l == 0) {
                        a = grid[i][l];
                    }
                    if (i > 0) {
                        a = grid[i][l] + grid[i - 1][l];
                    }
                    if (l > 0) {
                        b = grid[i][l] + grid[i][l - 1];
                    }
                    grid[i][l] = Math.min(a, b);
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }

        public int min = -1;

        public int move(int[][] grid, int x, int y) {
            int row = grid.length;
            int vert = grid[0].length;
            if (x == row - 1 && y == vert - 1) {
                return grid[x][y];
            }
            int a = Integer.MAX_VALUE;
            int b = Integer.MAX_VALUE;
            if (x + 1 < row) {
                a = grid[x][y] + move(grid, x + 1, y);
            }
            if (y + 1 < vert) {
                b = grid[x][y] + move(grid, x, y + 1);
            }
            return Math.min(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}