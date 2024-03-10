//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1118 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author DY
 * @date 2024-02-04 15:27:26
 */
public class PascalsTriangle_118 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PascalsTriangle_118().new Solution();
        List<List<Integer>> generate = solution.generate(5);
        System.out.println(generate);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return Collections.emptyList();
            }
            List<List<Integer>> arrayLists = new ArrayList<>(numRows);
            arrayLists.add(Collections.singletonList(1));
            for (int i = 1; i < numRows; i++) {
                int aNum = i + 1;
                List<Integer> innerList = new ArrayList<>(aNum);
                List<Integer> upperList = arrayLists.get(i - 1);
                innerList.add(1);
                for (int j = 1; j < aNum - 1; j++) {
                    Integer upperTotal = upperList.get(j - 1) + upperList.get(j);
                    innerList.add(upperTotal);
                }
                innerList.add(1);
                arrayLists.add(innerList);
            }
            return arrayLists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}