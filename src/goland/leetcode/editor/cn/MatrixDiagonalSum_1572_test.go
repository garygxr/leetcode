package leetcode

import (
	"testing"
)

//给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
//
// 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
//
//
//
// 示例 1：
//
//
//
//
//输入：mat = [[1,2,3],
//            [4,5,6],
//            [7,8,9]]
//输出：25
//解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
//请注意，元素 mat[1][1] = 5 只会被计算一次。
//
//
// 示例 2：
//
//
//输入：mat = [[1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1],
//            [1,1,1,1]]
//输出：8
//
//
// 示例 3：
//
//
//输入：mat = [[5]]
//输出：5
//
//
//
//
// 提示：
//
//
// n == mat.length == mat[i].length
// 1 <= n <= 100
// 1 <= mat[i][j] <= 100
//
//
// Related Topics 数组 矩阵 👍 130 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func diagonalSum(mat [][]int) int {
	n := len(mat)
	count := 0
	for i := 0; i < n; i++ {
		count += mat[i][i]
		if i != n-i-1 {
			count += mat[i][n-i-1]
		}
	}
	return count
}

//leetcode submit region end(Prohibit modification and deletion)

func TestMatrixDiagonalSum(t *testing.T) {
	sum := diagonalSum([][]int{{5}})
	println(sum)
}
