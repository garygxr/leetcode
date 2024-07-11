package leetcode

import (
	"testing"
)

//给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"
//输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
//
// Related Topics 位运算 哈希表 字符串 👍 132 👎 0

// leetcode submit region begin(Prohibit modification and deletion)
func canPermutePalindrome(s string) bool {
	var hashMap = make(map[byte]int)
	for _, i2 := range s {
		hashMap[byte(i2)]++
	}
	count := 0
	for b := range hashMap {
		i := hashMap[b]
		if i%2 != 0 {
			count++
		}
	}
	return count <= 1
}

//leetcode submit region end(Prohibit modification and deletion)

func TestPalindromePermutationLcci(t *testing.T) {
	palindrome := canPermutePalindrome("tactcoa")
	println(palindrome)
}
