//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1234 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 加一
 *
 * @author DY
 * @date 2023-06-07 08:51:10
 */
public class PlusOne_66 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PlusOne_66().new Solution();
        int[] ints = solution.plusOne(new int[]{0});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            ArrayDeque<Integer> integers = new ArrayDeque<>(digits.length + 1);
            int i1 = digits[digits.length - 1] + 1;
            integers.push(i1 % 10);
            int jin = i1 / 10;
            for (int i = digits.length - 2; i >= 0; i--) {
                int i2 = digits[i] + jin;
                integers.push(i2 % 10);
                jin = i2 / 10;
            }
            if (jin>0){
                integers.push(jin);
            }
            int[] ints = new int[integers.size()];
            for (int i = 0; i < ints.length; i++) {
                ints[i]=integers.pop();
            }
            return ints;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}