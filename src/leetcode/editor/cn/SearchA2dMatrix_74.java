//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 691 👎 0

package leetcode.editor.cn;

/**
 * @author gary gan
 * @date 2022-08-03 23:12:49
 */
public class SearchA2dMatrix_74 {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix_74().new Solution();
        int[][] a = {{1}};
        boolean b = solution.searchMatrix(a, 0);
        System.out.println(b);
    }

    /**
     * 搜索二维矩阵
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int low = -1, high = matrix.length - 1;
            while (low < high) {
                int mid = (high - low + 1) / 2 + low;
                if (matrix[mid][0] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            if (low < 0) {
                return false;
            }
            int left = 0;
            int right = matrix[low].length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[low][mid] == target) {
                    return true;
                }
                if (matrix[low][mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}