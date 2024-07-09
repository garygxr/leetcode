//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2487 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * @author DY
 * @date 2024-07-02 17:01:44
 */
public class KthLargestElementInAnArray_215 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new KthLargestElementInAnArray_215().new Solution();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 小顶堆
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(o -> o));
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.add(num);
                } else if (queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
            return queue.poll();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}