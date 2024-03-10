//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1395 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author DY
 * @date 2023-06-06 09:10:57
 */
public class SpiralMatrix_54 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new SpiralMatrix_54().new Solution();
        List<Integer> integers = solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(integers);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;
            ArrayList<Integer> integers = new ArrayList<>(matrix.length * matrix[0].length);
            while (top <= bottom && left <= right) {
                int[] matrix1 = matrix[top];
                int tempA = left++;
                while (tempA <= right) {
                    int matrix2 = matrix[top][tempA++];
                    integers.add(matrix2);
                }

                int tempN = top++;
                while (tempN < bottom) {
                    int matrix2 = matrix[++tempN][right];
                    integers.add(matrix2);
                }
                int tempW = right--;
                while (tempW > left) {
                    int matrix3 = matrix[bottom][--tempW];
                    integers.add(matrix3);
                }
                int tempE = bottom--;
                while (tempE > top) {
                    int matrix4 = matrix[--tempE][left];
                    integers.add(matrix4);
                }
            }
            return integers;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}