//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 848 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;

/**
 * @author  gary gan
 * @date 2022-07-29 11:33:20
 */
public class RemoveKDigits_402{
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits_402().new Solution();
        String s = solution.removeKdigits("11234", 2);
        System.out.println(s);
    }
       /**
     * 移掉 K 位数字
     */
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length()==k){
            return "0";
        }
        char[] chars = num.toCharArray();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() > chars[i] && k>0){
                deque.removeLast();
                k--;
            }
            deque.addLast(chars[i]);
        }
        while (k-- > 0){
            deque.removeLast();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : deque) {
            if (stringBuilder.length()==0 && character=='0'){
                continue;
            }
            stringBuilder.append(character);
        }
        if (stringBuilder.length()==0){
            return "0";
        }
        return  stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}