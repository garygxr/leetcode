//////////////////////给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, 
////upper] 
//////（包
////////含 
//////////
//////////////lower 
////////////////和 
//////////////////
//////////////////////upper）之内的 区间和的个数 。 
//////////////////////
////////////////////// 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。 
//
//////////////////////
////////////////////// 
//////////////////////示例 1：
//////////////////////
////////////////////// 
//////////////////////输入：nums = [-2,5,-1], lower = -2, upper = 2
//////////////////////输出：3
//////////////////////解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
////////////////////// 
//////////////////////
////////////////////// 示例 2： 
//////////////////////
////////////////////// 
//////////////////////输入：nums = [0], lower = 0, upper = 0
//////////////////////输出：1
////////////////////// 
//////////////////////
////////////////////// 
//////////////////////
////////////////////// 提示： 
//////////////////////
////////////////////// 
////////////////////// 1 <= nums.length <= 10⁵ 
////////////////////// -2³¹ <= nums[i] <= 2³¹ - 1 
////////////////////// -10⁵ <= lower <= upper <= 10⁵ 
////////////////////// 题目数据保证答案是一个 32 位 的整数 
////////////////////// 
////////////////////// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 462 👎 0
////////////////////
//////////////////
////////////////
//////////////
////////////
//////////
////////
//////
////
//

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

/**
 * @author YourName
 * @date 2022-07-15 21:37:54
 */
public class CountOfRangeSum_327 {
    public static void main(String[] args) {
        Solution solution = new CountOfRangeSum_327().new Solution();
        int[] ints = new ArraySort().generateRandomArray(5, -3, 3);
        int i = solution.countRangeSum(ints, -564,3864);
       System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            long[] sum = new long[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < sum.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            return count(sum, 0, sum.length - 1, lower, upper);
        }

        public int count(long[] sum, int l, int r, int lower, int upper) {
            if (l >= r) {
                if (sum[l] >= lower && sum[l] <= upper) {
                    return 1;
                }
                return 0;
            }
            int mid = l + ((r-l)>>1) ;
            int count= count(sum, l, mid, lower, upper) +
                    count(sum, mid + 1, r, lower, upper) +
                    merge(sum, l, mid, r, lower, upper);
         //   System.out.println(count);
            return count;
        }


        public int merge(long[] sum, int l, int mid, int r, int lower, int upper) {
            int count = 0;
            int windowsL = l;
            int windowsR = l;
            for (int i = mid + 1; i <= r; i++) {
                long changeUpper = sum[i] - lower;
                long changeLower = sum[i] - upper;
                while (windowsR <= mid && sum[windowsR] <= changeUpper) {
                    windowsR++;
                }

                while (windowsL <= mid && sum[windowsL] < changeLower) {
                    windowsL++;
                }

                count += Math.max(0, windowsR - windowsL);
            }
            long[] temp = new long[r - l + 1];
            int i = 0;
            int pos1 = l;
            int pos2 = mid + 1;
            while (pos1 <= mid && pos2 <= r) {
                if (sum[pos1] < sum[pos2]) {
                    temp[i++] = sum[pos1++];
                } else {
                    temp[i++] = sum[pos2++];
                }
            }

            while (pos1 > mid && pos2 <= r) {
                temp[i++] = sum[pos2++];
            }

            while (pos1 <= mid && pos2 > r) {
                temp[i++] = sum[pos1++];
            }

            for (int j = 0; j < temp.length; j++) {
                sum[l + j] = temp[j];
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}