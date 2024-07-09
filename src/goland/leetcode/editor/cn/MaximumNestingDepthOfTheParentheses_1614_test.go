package leetcode

import (
	"testing"
)

//给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
//
//
//
// 示例 1：
//
//
// 输入：s = "(1+(2*3)+((8)/4))+1"
//
//
// 输出：3
//
// 解释：数字 8 在嵌套的 3 层括号中。
//
// 示例 2：
//
//
// 输入：s = "(1)+((2))+(((3)))"
//
//
// 输出：3
//
// 解释：数字 3 在嵌套的 3 层括号中。
//
// 示例 3：
//
//
// 输入：s = "()(())((()()))"
//
//
// 输出：3
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
// 题目数据保证括号字符串 s 是 有效的括号字符串
//
//
// Related Topics 栈 字符串 👍 145 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func maxDepth(s string) (ans int) {
	size := 0
	for _, ch := range s {
		if ch == '(' {
			size++
			if size > ans {
				ans = size
			}
		} else if ch == ')' {
			size--
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)

func TestMaximumNestingDepthOfTheParentheses(t *testing.T) {

}
