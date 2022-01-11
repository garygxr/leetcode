package leetcode.editor.cn;

//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 556 👎 0

public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
        boolean b = solution.searchMatrix(new int[][]{{1}}, 0);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowIndex = findMidints(matrix, target);
            if (rowIndex<0){
                return false;
            }
            boolean mid = findMid(matrix[rowIndex], target);
            return mid;
        }

        public int findMidints(int[][] matrix, int target) {
            int top = -1,button =matrix.length-1;
            while (top<button){
               int mid = (button-top+1)/2+top;
                if (matrix[mid][0]<=target) {
                    top = mid;
                }else {
                    button = mid-1;
                }
            }
            return top;
        }

        public boolean findMid(int[] matix,int target){
            int start =0,end  = matix.length-1;
            while (start<=end){
               int mid=(start+end)/2;
               if (matix[mid]==target){
                   return true;
               } else if (matix[mid]<target){
                   start=mid+1;
               }else {
                   end=mid-1;
               }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}