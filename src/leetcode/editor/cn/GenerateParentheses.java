package leetcode.editor.cn;

////数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：n = 3
////输出：["((()))","(()())","(())()","()(())","()()()"]
//// 
////
//// 示例 2： 
////
//// 
////输入：n = 1
////输出：["()"]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= n <= 8 
//// 
//// Related Topics 字符串 动态规划 回溯 👍 2260 👎 0
//

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<String> generateParenthesis(int n) {
            List<String> combinations = new ArrayList();
            generateAll(new char[2 * n], 0, combinations, 0, 0);
            return combinations;
        }

        public void generateAll(char[] current, int pos, List<String> result, int leftBalance, int rightBalance) {
            if (pos == current.length) {
                if (valid(current)) {
                    result.add(new String(current));
                }
            } else {
                if (leftBalance < current.length / 2) {
                    current[pos] = '(';
                    generateAll(current, pos + 1, result, leftBalance+1, rightBalance);
                }
                if (rightBalance < leftBalance) {
                    current[pos] = ')';
                    generateAll(current, pos + 1, result, leftBalance, rightBalance+1);
                }

            }
        }

        public boolean valid(char[] current) {
            int balance = 0;
            for (char c : current) {
                if (c == '(') balance++;
                else balance--;
                if (balance < 0) return false;
            }
            return (balance == 0);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}