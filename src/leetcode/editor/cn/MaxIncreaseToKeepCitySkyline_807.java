//给你一座由 n x n 个街区组成的城市，每个街区都包含一座立方体建筑。给你一个下标从 0 开始的 n x n 整数矩阵 grid ，其中 grid[r][
//c] 表示坐落于 r 行 c 列的建筑物的 高度 。 
//
// 城市的 天际线 是从远处观察城市时，所有建筑物形成的外部轮廓。从东、南、西、北四个主要方向观测到的 天际线 可能不同。 
//
// 我们被允许为 任意数量的建筑物 的高度增加 任意增量（不同建筑物的增量可能不同） 。 高度为 0 的建筑物的高度也可以增加。然而，增加的建筑物高度 不能影
//响 从任何主要方向观察城市得到的 天际线 。 
//
// 在 不改变 从任何主要方向观测到的城市 天际线 的前提下，返回建筑物可以增加的 最大高度增量总和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
//输出：35
//解释：建筑物的高度如上图中心所示。
//用红色绘制从不同方向观看得到的天际线。
//在不影响天际线的情况下，增加建筑物的高度：
//gridNew = [ [8, 4, 8, 7],
//            [7, 4, 7, 7],
//            [9, 4, 8, 7],
//            [3, 3, 3, 3] ]
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[0,0,0],[0,0,0]]
//输出：0
//解释：增加任何建筑物的高度都会导致天际线的变化。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[r].length 
// 2 <= n <= 50 
// 0 <= grid[r][c] <= 100 
// 
// Related Topics 贪心 数组 矩阵 👍 230 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

/**
 * @author gary gan
 * @date 2022-07-21 11:00:13
 */
public class MaxIncreaseToKeepCitySkyline_807 {
    public static void main(String[] args) {
        Solution solution = new MaxIncreaseToKeepCitySkyline_807().new Solution();
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        int i = solution.maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int[] maxRowArray = new int[grid[0].length];
            for (int i = 0; i < maxRowArray.length; i++) {
                maxRowArray[i] = -1;
            }
            int[] maxVertArray = new int[grid.length];
            for (int i = 0; i < maxVertArray.length; i++) {
                maxVertArray[i] = -1;
            }


            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int l = 0; l < grid[i].length; l++) {
                    int maxRow;
                    int maxVert;
                    if (maxRowArray[i] != -1) {
                        maxRow = maxRowArray[i];
                    } else {
                        maxRow = findMaxRow(grid, i);
                        maxRowArray[i] = maxRow;
                    }

                    if (maxVertArray[l] != -1) {
                        maxVert = maxVertArray[l];
                    } else {
                        maxVert = findMaxVert(grid, l);
                        maxVertArray[l] = maxVert;
                    }
                    int min = Math.min(maxRow, maxVert);
                    count += min - grid[i][l];
                }
            }
            return count;
        }

        public int findMaxRow(int[][] grid, int vert) {
            int max = grid[vert][0];
            for (int i = 1; i < grid[vert].length; i++) {
                if (max < grid[vert][i]) {
                    max = grid[vert][i];
                }
            }
            return max;
        }

        public int findMaxVert(int[][] grid, int row) {
            int max = grid[0][row];
            for (int i = 1; i < grid.length; i++) {
                if (max < grid[i][row]) {
                    max = grid[i][row];
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}