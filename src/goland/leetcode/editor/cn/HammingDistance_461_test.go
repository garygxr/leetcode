package leetcode

import (
	"testing"
)

//两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
//
//
//
// 示例 1：
//
//
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
//
//
// 示例 2：
//
//
//输入：x = 3, y = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 0 <= x, y <= 2³¹ - 1
//
//
// Related Topics 位运算 👍 745 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func hammingDistance(x int, y int) int {
	count := 0
	for x != y {
		i := x & 1
		i2 := y & 1
		if i != i2 {
			count++
		}
		x = x >> 1
		y = y >> 1
	}
	return count
}

//leetcode submit region end(Prohibit modification and deletion)

func TestHammingDistance(t *testing.T) {
	distance := hammingDistance(1, 4)
	println(distance)
}
