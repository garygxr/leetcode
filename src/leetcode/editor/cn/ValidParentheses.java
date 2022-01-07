package leetcode.editor.cn;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 2873 👎 0

import leetcode.editor.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        boolean valid = solution.isValid(")");
        System.out.println(valid);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='('||c=='['||c=='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (pop==null){
                    return false;
                }
                if (c==')'){
                    if (!pop.equals('(')){
                        return false;
                    }
                }
                if (c==']'){
                    if (!pop.equals('[')){
                        return false;
                    }
                }
                if (c=='}'){
                    if (!pop.equals('{')){
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty()?true:false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}