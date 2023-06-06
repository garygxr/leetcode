//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1375 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 全排列 II
 *
 * @author DY
 * @date 2023-06-05 08:55:46
 */
public class PermutationsIi_47 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PermutationsIi_47().new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            ArrayDeque<Integer> dump = new ArrayDeque<>(nums.length);
            for (int num : nums) {
                dump.add(num);
            }
            List<List<Integer>> list = new ArrayList<>();
            process(list, new ArrayList<>(nums.length), dump);
            return list;
        }

        public void process(List<List<Integer>> list, List<Integer> current, ArrayDeque<Integer> dump) {
            if (dump.isEmpty()) {
                list.add(new ArrayList<>(current));
                return;
            }
            HashSet<Integer> integers = new HashSet<>();
            for (int i = 0; i < dump.size(); i++) {
                Integer pop = dump.pop();
                if (integers.contains(pop)) {
                    dump.add(pop);
                    continue;
                }else {
                    integers.add(pop);
                }
                current.add(pop);
                process(list, current, dump);
                current.remove(current.size() - 1);
                dump.add(pop);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}