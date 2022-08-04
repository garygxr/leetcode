//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 972 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author gary gan
 * @date 2022-07-24 09:49:03
 */
public class LargestNumber_179 {
    public static void main(String[] args) {
        Solution solution = new LargestNumber_179().new Solution();
        int[] a = {0,0};
        String s = solution.largestNumber(a);
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            ArrayList<Integer> integers = new ArrayList<>(nums.length);
            for (int num : nums) {
                integers.add(num);
            }
            integers.sort((a,b)->{
                Long temp1 =Long.valueOf(a.toString() + b.toString());
                Long temp2 =Long.valueOf(b.toString() + a.toString());
                if (temp1>temp2){
                    return -1;
                }else {
                    return 1;
                }
            });
            StringBuilder stringBuilder = new StringBuilder();
            integers.forEach(i -> stringBuilder.append(i));
            String s = stringBuilder.toString();
            if (s.startsWith("0")){
                return "0";
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}