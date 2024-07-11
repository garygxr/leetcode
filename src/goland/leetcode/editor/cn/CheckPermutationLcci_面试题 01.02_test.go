package leetcode

import (
	"testing"
)

//给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
//
//输入: s1 = "abc", s2 = "bca"
//输出: true
//
//
// 示例 2：
//
//
//输入: s1 = "abc", s2 = "bad"
//输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
//
// Related Topics 哈希表 字符串 排序 👍 173 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func CheckPermutation(s1 string, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}
	var hashMap = make(map[byte]int)
	for _, i := range s1 {
		hashMap[byte(i)]++
	}
	for _, i := range s2 {
		hashMap[byte(i)]--
		if hashMap[byte(i)] < 0 {
			return false
		}
	}
	return true
}

//leetcode submit region end(Prohibit modification and deletion)

func TestCheckPermutationLcci(t *testing.T) {
	permutation := CheckPermutation("abba", "bca")
	println(permutation)
}
