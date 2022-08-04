//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 2127 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gary gan
 * @date 2022-07-26 10:13:02
 */
public class Permutations_46 {
    public static void main(String[] args) {
        Solution solution = new Permutations_46().new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> numList = new ArrayList(nums.length);
            for (int num : nums) {
                numList.add(Integer.valueOf(num));
            }
            ArrayList<List<Integer>> lists = new ArrayList<>();
            buildList(numList, new ArrayList(), lists);
            return lists;
        }

        public void buildList(List<Integer> sourceList, List<Integer> targetList, ArrayList<List<Integer>> lists) {
            if (sourceList == null || sourceList.size() == 0) {
                lists.add(targetList);
                return;
            }


            for (int i = 0; i < sourceList.size(); i++) {
                ArrayList arrayList = new ArrayList<>(targetList);
                ArrayList<Integer> array = new ArrayList(sourceList);
                int remove = (int) array.remove(i);
                arrayList.add(remove);
                buildList(array, arrayList, lists);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}