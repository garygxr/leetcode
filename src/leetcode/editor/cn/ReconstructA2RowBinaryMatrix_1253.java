////给你一个 2 行 n 列的二进制数组： 
////
//// 
//// 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。 
//// 第 0 行的元素之和为 upper。 
//// 第 1 行的元素之和为 lower。 
//// 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。 
//// 
////
//// 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。 
////
//// 如果有多个不同的答案，那么任意一个都可以通过本题。 
////
//// 如果不存在符合要求的答案，就请返回一个空的二维数组。 
////
//// 
////
//// 示例 1： 
////
//// 输入：upper = 2, lower = 1, colsum = [1,1,1]
////输出：[[1,1,0],[0,0,1]]
////解释：[[1,0,1],[0,1,0]] 和 [[0,1,1],[1,0,0]] 也是正确答案。
//// 
////
//// 示例 2： 
////
//// 输入：upper = 2, lower = 3, colsum = [2,2,1,1]
////输出：[]
//// 
////
//// 示例 3： 
////
//// 输入：upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
////输出：[[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= colsum.length <= 10^5 
//// 0 <= upper, lower <= colsum.length 
//// 0 <= colsum[i] <= 2 
//// 
//// Related Topics 贪心 数组 矩阵 👍 26 👎 0
//

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gary gan
 * @date 2022-07-22 10:01:56
 */
public class ReconstructA2RowBinaryMatrix_1253 {
    public static void main(String[] args) {
        Solution solution = new ReconstructA2RowBinaryMatrix_1253().new Solution();
        int[] a = {2,1,2,2,1,1,1};
        List<List<Integer>> lists = solution.reconstructMatrix(4, 7, a);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            int[] ints = new int[colsum.length];
            List<Integer> listA = Arrays.stream(ints).boxed().collect(Collectors.toList());
            List<Integer> listB = Arrays.stream(ints).boxed().collect(Collectors.toList());
            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] == 2) {
                    if (upper <= 0 || lower <= 0){
                        return new ArrayList<>(0);
                    }
                    listA.set(i, 1);
                    upper--;
                    listB.set(i, 1);
                    lower--;
                }
            }

            for (int i = 0; i < colsum.length; i++) {
                if (colsum[i] != 1) {
                    continue;
                }
                if (upper > 0) {
                    upper--;
                    listA.set(i, 1);
                } else if (lower > 0) {
                    lower--;
                    listB.set(i, 1);
                } else {
                    return new ArrayList<>(0);
                }
            }
            if (lower>0||upper>0){
                return new ArrayList<>(0);
            }
            List<List<Integer>> lists = new ArrayList<>(2);
            lists.add(listA);
            lists.add(listB);
            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}