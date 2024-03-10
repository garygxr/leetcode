//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 1887 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

/**
 * 最长连续序列
 *
 * @author DY
 * @date 2023-11-15 18:23:51
 */
public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LongestConsecutiveSequence_128().new Solution();
        int i = solution.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        System.out.println(i);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> set = new HashSet<>(nums.length);
            HashSet<Integer> flagSet = new HashSet<>(nums.length);
            for (int num : nums) {
                set.add(num);
            }
            int longestNum = 0;
            for (Integer num : set) {
                if (flagSet.contains(num)) {
                    continue;
                }
                int currentNum = 1;
                while (set.contains(++num)) {
                    flagSet.add(num);
                    currentNum++;
                }
                if (longestNum < currentNum) {
                    longestNum = currentNum;
                }
            }
            return longestNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}