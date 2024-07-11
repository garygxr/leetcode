package leetcode

import (
	"testing"
)

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
//
//输入: s = "leetcode"
//输出: false
//
//
// 示例 2：
//
//
//输入: s = "abc"
//输出: true
//
//
// 限制：
//
//
// 0 <= len(s) <= 100
// s[i]仅包含小写字母
// 如果你不使用额外的数据结构，会很加分。
//
//
// Related Topics 位运算 哈希表 字符串 排序 👍 333 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func isUnique(astr string) bool {
	// 从a遍历到z
	for i := 'a'; i <= 'z'; i++ {
		count := 0
		for _, i2 := range astr {
			if i == i2 {
				count++
			}
			if count > 1 {
				return false
			}
		}
	}
	return true

}

//leetcode submit region end(Prohibit modification and deletion)

func TestIsUniqueLcci(t *testing.T) {
	unique := isUnique("abc")
	println(unique)
}
