//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 1781 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.UnwarrantedOptimismException.isValid;

/**
 * N 皇后
 *
 * @author DY
 * @date 2023-06-05 11:34:26
 */
public class NQueens_51 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new NQueens_51().new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        System.out.println(lists);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //最终结果 字符串类型
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            //初始化棋盘 字符类型的二维数组
            char[][] chessboard = new char[n][n];
            //将棋盘的所有位置初始化为空位
            for (char[] c : chessboard) {
                Arrays.fill(c, '.');
            }

            backTrack(n, 0, chessboard);
            return result;
        }

        //n是皇后的个数，row是当前递归到第几行 chessboard是棋盘
        public void backTrack(int n, int row, char[][] chessboard) {
            if (row == n) {  //遍历到最后一行了
                result.add(Array2List(chessboard));
                return;
            }
            //col控制棋盘的列，每次都从新的一行的起始位置开始搜索
            for (int col = 0;col < n; ++col) {
                if (isValid (row, col, n, chessboard)) { //第row行，第col个位置放皇后是否合法
                    chessboard[row][col] = 'Q';  //合法的话放皇后
                    backTrack(n, row+1, chessboard); //下次遍历第二行
                    chessboard[row][col] = '.';   //回溯
                }
            }

        }


        public List Array2List(char[][] chessboard) {

            //用于存储转换后的字符串--字符转换成字符串
            List<String> list = new ArrayList<>();
            // 迭代遍历 chessboard 数组中的每一行，使用 c 作为当前行的引用。
            for (char[] c : chessboard) {
                //- 将当前行 c 转换为一个字符串，并将该字符串添加到 list 列表中。
                //String.copyValueOf(c) 方法用于创建一个新的字符串，该字符串包含了字符数组 c 中的所有字符。
                list.add(String.copyValueOf(c));
            }
            return list;
        }


        public boolean isValid(int row, int col, int n, char[][] chessboard) {
            // 检查列--遍历的是行
            for (int i=0; i<row; ++i) { // 相当于剪枝
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查45度对角线 代码中的循环从 (row-1, col-1) 的位置开始，也就是给定位置的上方左侧一格
            //通过 i-- 和 j-- 的方式，在每次迭代中将 i 和 j 分别递减，以便沿着45度对角线向上和向左移动。
            //我们可以在第一次迭代时检查 (row-1, col-1) 的位置是否为皇后。然后，通过每次迭代递减 i 和 j，我们可以依次检查上方和左侧的位置，直到到达棋盘的边界。
            //循环的终止条件是 i>=0 && j>=0，这意味着只要 i 和 j 中有一个小于0，循环就会停止。这是为了确保我们只检查到达或越过棋盘边界之前的位置。
            for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查135度对角线 代码中的循环从 (row-1, col+1) 的位置开始，也就是给定位置的上方右侧一格。
            //通过 i-- 和 j++ 的方式，在每次迭代中将 i 递减、j 递增，以便沿着135度对角线向上和向右移动。
            //我们可以在第一次迭代时检查 (row-1, col+1) 的位置是否为皇后。然后，通过每次迭代递减 i 和递增 j，我们可以依次检查上方和右侧的位置，直到到达棋盘的边界。
            //在这段代码中，j 代表列数，而 n 是棋盘的大小，即棋盘的列数。因为数组索引是从0开始的，所以棋盘的列数是从0到n-1。在循环中，我们希望在沿着135度对角线向上和向右移动时，j 的值不会超过棋盘的列数。因此，循环条件中使用 j <= n-1 来确保 j 的值在有效的列范围内。如果不将条件写为 j <= n-1，而是 j < n，当 j 的值等于 n 时，循环将停止。这可能会导致在检查对角线时遗漏最右边的列。
            for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}