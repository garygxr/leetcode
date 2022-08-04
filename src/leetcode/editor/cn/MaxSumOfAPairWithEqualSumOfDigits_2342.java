//给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与 
//nums[j] 的数位和相等。 
//
// 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [18,43,36,13,7]
//输出：54
//解释：满足条件的数对 (i, j) 为：
//- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
//- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
//所以可以获得的最大和是 54 。 
//
// 示例 2： 
//
// 
//输入：nums = [10,12,19,14]
//输出：-1
//解释：不存在满足条件的数对，返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 8 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

/**
 * @author gary gan
 * @date 2022-07-27 08:49:25
 */
public class MaxSumOfAPairWithEqualSumOfDigits_2342 {
    public static void main(String[] args) {
        Solution solution = new MaxSumOfAPairWithEqualSumOfDigits_2342().new Solution();
        int[] a = {18,43,36,13,7};
        int i = solution.maximumSum(a);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSum(int[] nums) {
            HashMap<Integer, Integer> numMap = new HashMap<>(nums.length);
            int max = -1;
            for (int i = 0; i < nums.length; i++) {
                int sumNumber = sumNumber(nums[i]);
                Integer oldNumber = numMap.get(sumNumber);
                if (oldNumber == null) {
                    numMap.put(sumNumber, nums[i]);
                } else {
                    max = oldNumber + nums[i] > max ? oldNumber + nums[i] : max;
                    if (nums[i]>oldNumber){
                        numMap.put(sumNumber,nums[i]);
                    }
                }
            }
            return max;
        }

        public int sumNumber(int num) {
            int count = 0;
            while (num > 0) {
                int i = num % 10;
                count += i;
                num /= 10;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}