//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2482 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author DY
 * @date 2023-06-02 13:51:44
 */
public class LetterCombinationsOfAPhoneNumber_17 {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new LetterCombinationsOfAPhoneNumber_17().new Solution();
        List<String> strings = solution.letterCombinations("");
        System.out.println(strings);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            if (digits.length()==0){
                return Collections.emptyList();
            }
            HashMap<Character, List<Character>> numbers = new HashMap<>(8);
            numbers.put('2', Arrays.asList('a', 'b', 'c'));
            numbers.put('3', Arrays.asList('d', 'e', 'f'));
            numbers.put('4', Arrays.asList('g', 'h', 'i'));
            numbers.put('5', Arrays.asList('j', 'k', 'l'));
            numbers.put('6', Arrays.asList('m', 'n', 'o'));
            numbers.put('7', Arrays.asList('p', 'q', 'r', 's'));
            numbers.put('8', Arrays.asList('t', 'u', 'v'));
            numbers.put('9', Arrays.asList('w', 'x', 'y', 'z'));

            ArrayList<String> stringArrayList = new ArrayList<>();
            ArrayDeque<Character> heap = new ArrayDeque<>();
            for (int i = 0; i < digits.length(); i++) {
                heap.add(digits.charAt(i));
            }
            process(heap, numbers, new StringBuilder(4), stringArrayList);
            return stringArrayList;
        }


        public void process(ArrayDeque<Character> heap, Map<Character, List<Character>> numbers, StringBuilder currnet, List<String> list) {
            Character c = heap.poll();
            if (c == null) {
                list.add(currnet.toString());
                return;
            }
            List<Character> enc = numbers.get(c);
            for (int i = 0; i < enc.size(); i++) {
                process(heap, numbers, new StringBuilder(currnet).append(enc.get(i)), list);
            }
            heap.push(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}