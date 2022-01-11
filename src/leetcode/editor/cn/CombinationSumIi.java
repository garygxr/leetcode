package leetcode.editor.cn;

//给你一个由候选元素组成的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
//
// candidates 中的每个元素在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 791 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        List<List<Integer>> lists = solution.combinationSum2(new int[]{1, 1, 2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> combinationList = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            buildCombination(candidates, target, new ArrayList<>(), 0, 0);
            return combinationList;
        }

        public void buildCombination(int[] candidates, int targer, List<Integer> combination, int pathSum, int startIndex) {
            if (pathSum > targer) {
                return;
            }

            if (pathSum == targer) {
                combinationList.add(new ArrayList<>(combination));
                return;
            }

            for (int i = startIndex; i < candidates.length; i++) {
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (targer - pathSum >= candidates[i]) {
                    combination.add(candidates[i]);
                    buildCombination(candidates, targer, combination, pathSum + candidates[i], i + 1);
                    combination.remove(combination.size() - 1);
                } else {
                    break;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}