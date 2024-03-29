//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
// Related Topics 栈 双指针 字符串 模拟 👍 479 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gary gan
 * @date 2022-08-04 13:31:01
 */
public class BackspaceStringCompare_844 {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare_844().new Solution();
        solution.backspaceCompare("a##c","#a#c");
    }

    /**
     * 比较含退格的字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            String s1 = backString2(s);
            String s2 = backString2(t);
            return s1.equals(s2);
        }

        public String backString2(String str){
            ArrayDeque<Character> deque = new ArrayDeque<>();
            for (int i = 0; i < str.length() ; i++) {
                char c = str.charAt(i);
                if (c!='#'){
                    deque.addLast(c);
                }else if (!deque.isEmpty()){
                    deque.removeLast();
                }
            }
            return deque.toString();
        }

        public String backString(String str) {
            StringBuffer ret = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                char ch = str.charAt(i);
                if (ch != '#') {
                    ret.append(ch);
                } else {
                    if (ret.length() > 0) {
                        ret.deleteCharAt(ret.length() - 1);
                    }
                }
            }
            return ret.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}