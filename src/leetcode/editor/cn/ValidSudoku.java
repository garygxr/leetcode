package leetcode.editor.cn;

//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 735 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ValidSudoku().new Solution();
        char[][] strings = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        boolean validSudoku = solution.isValidSudoku(strings);
        System.out.println(validSudoku);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 一步到位，每一行、每一列、每一宫各用一个int类型的表示（只需要用到9位）
            short[] rows = new short[9];
            short[] cols = new short[9];
            short[] gongs = new short[9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        // 转换成十进制的值
                        int val = board[i][j] - '0';
                        // 查看行、列、宫是否被占用 // 宫的计算方式为：i/3*3+j/3，表示每九个小格子为一宫
                        if (occupied(rows[i], val) || occupied(cols[j], val) || occupied(gongs[i / 3 * 3 + j / 3], val)) {
                            return false;
                        }
                        // 如果行、列、宫中任意一个已占用，返回false return false; }
                        // 设置行、列、宫中这个值已占用
                        set(rows, i, val);
                        set(cols, j, val);
                        set(gongs, i / 3 * 3 + j / 3, val);
                    }
                }
            }
            return true;
        }

        private boolean occupied(int data, int val) {
            // 查看第 val 位是否为1，即已占用
            return ((data >> val) & 1) == 1;
        }

        private void set(short[] arr, int pos, int val) {
            // 设置第 val 位为1，占用这个位置
            arr[pos] |= (1 << val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}