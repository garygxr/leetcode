//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
//
// Related Topics 数组 👍 712 👎 0


package leetcode.editor.cn;

import java.util.List;

/**
 * 插入区间
 * @author DY
 * @date 2023-06-06 08:43:39
 */
public class InsertInterval_57{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new InsertInterval_57().new Solution();
	 }
	 
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int left = newInterval[0], right = newInterval[1];
            boolean flag = false;
            List<int[]> list = new ArrayList<>();
            for (int[] interval : intervals) {
                if (interval[0] > right) {
                    if (!flag) {
                        list.add(new int[]{left, right});
                        flag = true;
                    }
                    list.add(interval);
                } else if (interval[1] < left) {
                    list.add(interval);
                } else {
                    left = Math.min(left, interval[0]);
                    right = Math.max(right, interval[1]);
                }
            }
            if (!flag) {
                list.add(new int[]{left, right});
            }
            int[][] res = new int[list.size()][];
            for (int i = 0; i < list.size(); ++i) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}